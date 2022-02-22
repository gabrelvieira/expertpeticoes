package br.com.expertpeticoes.curso.controller.pagamento;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

	private static final String ACCESS_TOKEN = "TEST-3256739264421310-021300-d2d0f21bf5d9d12f56409ded7aa3f2fd-306346999";

	@Autowired
	private CursoEmail emailSender;
	
	@Autowired
	private VendaRepository vendaRepository;

	@PostMapping("/notification")
	@ResponseBody
	@Transactional
	public ResponseEntity<?> notificacao(@RequestBody(required = true) NotificationForm notification) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(
				"https://api.mercadopago.com/v1/payments/" + notification.getData().getId() + "?access_token=" + ACCESS_TOKEN)
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

		}
		if (js.get("status").toString().equals("approved")) {
			try {
				sendMail(js);
				
				persist(js);
				
			} catch (Exception e) {}
		}
		return ResponseEntity.ok().build();
	}
	
	
	private void sendMail(JSONObject js) throws Exception {
		js = (JSONObject) new JSONParser().parse(js.get("payer").toString());
		emailSender.sendMail(js.get("email").toString());
	}
	
	
	private void persist(JSONObject js) {
		
		Optional<Venda> vendaOptional =
				vendaRepository.findByEmail(js.get("email").toString());
		
		if(vendaOptional.get() == null) {
			Venda venda = vendaOptional.get();
			venda.setData(LocalDate.now());
			venda.setEmail(new Email().setEmail(js.get("email").toString())
					.setCursoGratuito(false)
					.setCursoPago(true)
					.setPropaganda(true)
					.setVenda(venda));
			
			this.vendaRepository.save(venda);
		}
		
		if(vendaOptional.get() != null) {
			Venda venda = vendaOptional.get();
			venda.getEmail().setCursoPago(true);
			venda.setData(LocalDate.now());
		}
	}
}
