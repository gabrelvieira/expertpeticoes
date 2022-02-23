package br.com.expertpeticoes.curso.email;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.expertpeticoes.curso.email.events.EmailEvent;
import br.com.expertpeticoes.curso.email.events.publisherEmail;
import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.model.form.EmailPromocional;
import br.com.expertpeticoes.curso.repository.EmailRepository;

@RestController
@RequestMapping("/adm/email")
public class EmailPromocionalController {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired 
	private publisherEmail publishEmail;
	
	@GetMapping("/sendPromotion")
	public ResponseEntity<?> sendMail(@RequestBody EmailPromocional emailPromocional) throws AddressException {
		EmailEvent event = new EmailEvent(this, emailPromocional);
		
		publishEmail.publish(event);
		System.out.println("Evento publicado, agora falta executar");
		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/testPromotion")
	public ResponseEntity<?> sendTesteEmail(@RequestBody EmailPromocional emailPromocional) {
		
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("gabrielvieira3101@gmail.com");
			helper.setTo("expertpeticoes@outlook.com");
			helper.setSubject(emailPromocional.getTitle());
			helper.setText("<body> <h1 style=\"color:red\">" + emailPromocional.getBody() + "</h1></body>",
					true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		System.out.println("um email enviado");
		emailSender.send(message);
		
		return ResponseEntity.ok().build();
	}
}
