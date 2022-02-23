package br.com.expertpeticoes.curso.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.expertpeticoes.curso.email.CursoEmail;
import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.form.EmailForm;
import br.com.expertpeticoes.curso.repository.EmailRepository;

@Controller
@RequestMapping("/adm/email")
public class CursoGratuito {

	@Autowired
	private CursoEmail email;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@GetMapping("/conteudoGratis")
	public String emailGratis() {
		return "html";
	}
	
	@PostMapping("/conteudoGratis")
	@Transactional
	public ResponseEntity<?> enviarConteudo(@RequestBody EmailForm emailForm) {
		this.email.sendEmailFree(emailForm.getEmail());
		Optional<Email> optionalEmail = this.emailRepository.findByEmail(emailForm.getEmail());
		
		System.out.println(optionalEmail.isEmpty());
		
		if(optionalEmail.isEmpty()) {
			Email email = new Email(emailForm.getEmail(),
					true, false, true);
			this.emailRepository.save(email);
		} else {
			optionalEmail.get().setCursoGratuito(true);
		}
		
		return ResponseEntity.ok().build();
	}
	
}
