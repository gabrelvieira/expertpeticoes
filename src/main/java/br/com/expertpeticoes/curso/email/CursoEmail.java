package br.com.expertpeticoes.curso.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.expertpeticoes.curso.dropbox.DownloadDrive;


@Controller
public class CursoEmail {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private DownloadDrive download;

	@GetMapping("/email/{to}")
	@ResponseBody
	public String teste(@PathVariable("to") String to) throws Exception{
		MimeMessage message = emailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("gabrielvieira3101@gmail.com");
			helper.setTo(to);
			helper.setSubject("Curso de Advocacia");
			helper.setText("<body> <h1 style=\"color:red\">Aqui está nosso material de qualidade</h1> </body>", true);
			FileSystemResource file = new FileSystemResource(new File("C:\\Users\\Usuario\\Desktop\\links.txt"));
			helper.addAttachment("Curso.zip", download.getFile());
			
		} catch (MessagingException e) {
			System.out.println("deu errado");
		}
		
		emailSender.send(message);
		
		return "<h1 style=\"text-align:center; color:green\">Email enviado com sucesso</h1>";
	}
	
}
