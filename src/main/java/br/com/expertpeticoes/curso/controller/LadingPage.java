package br.com.expertpeticoes.curso.controller;

import java.math.BigInteger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class LadingPage {

	@GetMapping("/")
	public String home() {
		return "pagina";
	}
	
	@PostMapping("/teste")
	@ResponseBody
	public BigInteger teste(@RequestBody Long tes) {
		System.out.println(tes);
		return new BigInteger("123");
	}
}