package br.com.expertpeticoes.curso.controller.pagamento;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPayment {

	@Bean
	public DadosPayment getPayment() {
		DadosPayment dados = new DadosPayment();
		dados.setValor(new BigDecimal("100"));
		dados.setPromocao(false);
		dados.setValorPromocional(new BigDecimal("50"));
		return dados;
	}
	
}