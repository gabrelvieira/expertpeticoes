package br.com.expertpeticoes.curso.configuration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.expertpeticoes.curso.email.CursoEmail;
import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.Venda;
import br.com.expertpeticoes.curso.repository.VendaRepository;

@Controller
public class Population {

	@Autowired
	private VendaRepository repository;
	
	@GetMapping("/popular")
	@ResponseBody
	public String popular() {
		
		List<Venda> vendas = new ArrayList<>();
		
		Venda venda = new Venda();
		venda.setData(LocalDate.of(2005, 1, 31));
		venda.setEmail(new Email().setEmail("gabrielvieira3101@gmail.com")
				.setCursoGratuito(true)
				.setCursoPago(true)
				.setPropaganda(true)
				.setVenda(venda));
		venda.setValor(new BigDecimal("50"));
		
		vendas.add(venda);
		
		Venda venda1 = new Venda();
		venda1.setData(LocalDate.of(2022, 2, 20));
		venda1.setEmail(new Email().setEmail("gabrielcursoa@gmail.com")
				.setCursoGratuito(false)
				.setCursoPago(true)
				.setPropaganda(true)
				.setVenda(venda1));
		venda1.setValor(new BigDecimal("40"));
		
		vendas.add(venda1);

		Venda venda2 = new Venda();
		venda2.setData(LocalDate.of(2008, 5, 25));
		venda2.setEmail(new Email().setEmail("gabrielcursoa@outlook.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda2));
		venda2.setValor(new BigDecimal("60"));
		
		vendas.add(venda2);

		Venda venda3 = new Venda();
		venda3.setData(LocalDate.of(2021, 12, 30));
		venda3.setEmail(new Email().setEmail("aluadodadisney@hotmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda3));
		venda3.setValor(new BigDecimal("40"));
		
		vendas.add(venda3);

		Venda venda4 = new Venda();
		venda4.setData(LocalDate.of(2012, 9, 27));
		venda4.setEmail(new Email().setEmail("gabrielvieira3101@gmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda4));
		venda4.setValor(new BigDecimal("50"));
		
		vendas.add(venda4);

		Venda venda5 = new Venda();
		venda5.setData(LocalDate.of(1999, 6, 3));
		venda5.setEmail(new Email().setEmail("zmaathclient@hotmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda5));
		venda5.setValor(new BigDecimal("50"));
		
		vendas.add(venda5);

		Venda venda6 = new Venda();
		venda6.setData(LocalDate.of(2018, 7, 6));
		venda6.setEmail(new Email().setEmail("gabrielcursoa@gmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda6));
		venda6.setValor(new BigDecimal("50"));
		
		vendas.add(venda6);

		Venda venda7 = new Venda();
		venda7.setData(LocalDate.of(2019, 4, 8));
		venda7.setEmail(new Email().setEmail("gabrielcursoa@outlook.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(false)
				.setVenda(venda7));
		venda7.setValor(new BigDecimal("80"));
		
		vendas.add(venda7);

		Venda venda8 = new Venda();
		venda8.setData(LocalDate.of(2005, 1, 2));
		venda8.setEmail(new Email().setEmail("gabrielvieira3101@gmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda8));
		venda8.setValor(new BigDecimal("50"));
		
		vendas.add(venda8);

		Venda venda9 = new Venda();
		venda9.setData(LocalDate.of(1995, 2, 27));
		venda9.setEmail(new Email().setEmail("gabrielvieira3101@gmail.com")
				.setCursoGratuito(true)
				.setCursoPago(false)
				.setPropaganda(true)
				.setVenda(venda9));
		venda9.setValor(new BigDecimal("30"));
		
		vendas.add(venda9);
		
		repository.saveAll(vendas);
		return "ok";
	}
}
