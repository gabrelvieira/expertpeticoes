package br.com.expertpeticoes.curso.controller.pagamento;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Optional;

import br.com.expertpeticoes.curso.email.CursoEmail;
import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.NotificationForm;
import br.com.expertpeticoes.curso.model.Venda;
import br.com.expertpeticoes.curso.repository.VendaRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Controller
public class Notification {

	@Autowired
	private DadosPayment dadosPayment;
	
	@Autowired
	private CursoEmail emailSender;
	
	@Autowired
	private VendaRepository vendaRepository;

	@PostMapping("/notification")
	@ResponseBody
	@Transactional
	public ResponseEntity<?> notificacao(@RequestBody(required = true) NotificationForm notification) {
		OkHttpClient client = new OkHttpClient();
		System.out.println("to aqui");
		Request request = new Request.Builder().url(
				"https://api.mercadopago.com/v1/payments/" + notification.getData().getId() + "?access_token=" + dadosPayment.getAcessToken())
				.build();

		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONObject js = null;

		try {
			js = (JSONObject) new JSONParser().parse(response.body().string());
		} catch (Exception e) {
			System.out.println();
		}
		if (js.get("status").toString().equals("approved")) {
			try {
				sendMail(js);
				System.out.println(js.toString());
				persist(js);
			} catch (Exception e) {e.printStackTrace();}
		}
		return ResponseEntity.ok().build();
	}
	
	
	private void sendMail(JSONObject js) throws Exception {
		js = (JSONObject) new JSONParser().parse(js.get("payer").toString());
		emailSender.sendMail(js.get("email").toString());
	}
	
	
	private void persist(JSONObject js) {
		
		try {
			js = (JSONObject) new JSONParser().parse(js.get("payer").toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Optional<Venda> vendaOptional =
				vendaRepository.findByEmail(js.get("email").toString());
		
		if(!vendaOptional.isPresent()) {
			Venda venda = new Venda();
			venda.setData(LocalDate.now());
			venda.setEmail(new Email().setEmail(js.get("email").toString())
					.setCursoGratuito(false)
					.setCursoPago(true)
					.setPropaganda(true)
					.setVenda(venda));
			
			if(this.dadosPayment.getPromocao()) {
				venda.setValor(this.dadosPayment.getValorPromocional());
			}else {
				venda.setValor(this.dadosPayment.getValor());
			}
			
			System.out.println(venda.getEmail().getEmail());
			
			this.vendaRepository.save(venda);
		}
		
		if(vendaOptional.isPresent()) {
			Venda venda = vendaOptional.get();
			venda.getEmail().setCursoPago(true);
			venda.setData(LocalDate.now());
		}
	}
}
