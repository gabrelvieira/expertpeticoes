package br.com.expertpeticoes.curso.controller.pagamento;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.expertpeticoes.curso.model.form.DadosPaymentForm;

@RestController
@RequestMapping("/adm/api")
@CrossOrigin
public class PaymentApi {
	
	@Autowired
	private DadosPayment dados;
	
	@PutMapping("/valor")
	public ResponseEntity<?> setValor(@RequestBody DadosPaymentForm form){
		
		dados.setValor(form.getValor());
		dados.setPromocao(form.getPromocao());
		System.out.println(form.getPromocao());
		dados.setValorPromocional(form.getValorPromocional());
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/novo-token/{token}")
	public String setToken(@PathVariable(name = "token") String token) {
		this.dados.setAcessToken(token);
		return ("o seu novo token é:" + token); 
	}
}
