package br.com.expertpeticoes.curso.email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.expertpeticoes.curso.controller.onedrive.OneDrive;



@Service
public class CursoEmail {
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
	private OneDrive oneDrive;
	
	public String sendMail(String to) throws Exception{
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("gabrielvieira3101@gmail.com");
			helper.setTo(to);
			helper.setSubject("Curso de Advocacia");
			helper.setText("<body> <h1 style=\"color:red\">Aqui está nosso material de qualidade</h1> <p>Mas aqui segue o link " + oneDrive.getLink("/Imagens/gabriel/apache.zip") + "</p></body>", true);
		} catch (MessagingException e) {
			System.out.println("deu errado");
		}
		System.out.println("enviando email");
		emailSender.send(message);
		
		return "<h1 style=\"text-align:center; color:green\">Email enviado com sucesso</h1>";
	}
	
	public void sendEmailFree(String to) {
		MimeMessage message = emailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("gabrielvieira3101@gmail.com");
			helper.setTo(to);
			helper.setSubject("Curso de Advocacia gratis");
			helper.setText("<body> <h1 style=\"color:red\">Aqui está nosso material de qualidade</h1> <p>Mas aqui segue o link " + oneDrive.getLink("/Imagens/gabriel/apache.zip") + "</p></body>", true);
		} catch (MessagingException e) { 
			System.out.println("deu errado");
		}
		System.out.println("enviando email");
		emailSender.send(message);
	}
}
