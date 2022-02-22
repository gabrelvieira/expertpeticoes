package br.com.expertpeticoes.curso.email;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmailPromocional {

	@Autowired
	private JavaMailSender emailSender;

	@GetMapping("/send")
	@ResponseBody
	public String sendMail() throws AddressException {

		MimeMessage message = emailSender.createMimeMessage();
		InternetAddress[] adress = InternetAddress
				.parse("gabrielvieira3101@gmail.com, gabrielcursoa@gmail.com, gabrielcursoa@outlook.com");
		for (int i = 0; adress.length > i; ++i) {
			try {
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setFrom("gabrielvieira3101@gmail.com");
				helper.setTo(adress[i]);
				helper.setSubject("Curso de Advocacia");
				helper.setText("<body> <h1 style=\"color:red\">Aqui está nosso material de qualidade</h1></body>",
						true);
			} catch (MessagingException e) {
				System.out.println("deu errado");
			}
			System.out.println("enviando email");
			emailSender.send(message);
		}
		return "<h1 style=\"text-align:center; color:green\">Email enviado com sucesso</h1>";

	}
}
