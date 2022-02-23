package br.com.expertpeticoes.curso.email.events;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import br.com.expertpeticoes.curso.model.Email;
import br.com.expertpeticoes.curso.repository.EmailRepository;

@Component
public class EmailListener implements ApplicationListener<EmailEvent> {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private EmailRepository emailRepository;

	@Override
	public void onApplicationEvent(EmailEvent event) {

		System.out.println("cheguei");
		
		ExecutorService pool = Executors.newCachedThreadPool();

		CompletableFuture.runAsync(() -> {

			MimeMessage message = emailSender.createMimeMessage();

			List<Email> emails = this.emailRepository.findEmailGratis();

			InternetAddress[] adress = null;
			try {
				adress = InternetAddress.parse(emails.toString().replace("[", "").replace("]", ""));
			} catch (AddressException e1) {
				e1.printStackTrace();
			}

			for (int i = 0; adress.length > i; ++i) {
				try {
					MimeMessageHelper helper = new MimeMessageHelper(message, true);
					helper.setFrom("gabrielvieira3101@gmail.com");
					helper.setTo(adress[i]);
					helper.setSubject(event.getEmail().getTitle());
					helper.setText("<body> <h1 style=\"color:red\">" + event.getEmail().getBody() + "</h1></body>",
							true);
				} catch (MessagingException e) {
					System.out.println("deu errado");
				}
				System.out.println("enviando email");
				emailSender.send(message);
			}
		}, pool);
	}

}
