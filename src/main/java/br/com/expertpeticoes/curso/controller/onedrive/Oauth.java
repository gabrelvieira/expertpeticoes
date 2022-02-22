package br.com.expertpeticoes.curso.controller.onedrive;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Oauth {

	@GetMapping("/auth")
	@ResponseBody
	public String auth(String code, String error_description) {
		if(code != null)
			System.out.println(code);
		
		return "OPA AMIGO DEU CERTO SUA AUTENTIFICAÇÃO PODE FAZER A FESTA";
	}
}
