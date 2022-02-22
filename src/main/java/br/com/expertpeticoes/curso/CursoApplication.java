package br.com.expertpeticoes.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import br.com.expertpeticoes.curso.configuration.Population;
import br.com.expertpeticoes.curso.email.CursoEmail;

@SpringBootApplication
public class CursoApplication {

	@Autowired
	private static Population pop;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}
	
}