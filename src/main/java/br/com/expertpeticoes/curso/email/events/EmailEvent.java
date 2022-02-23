package br.com.expertpeticoes.curso.email.events;

import org.springframework.context.ApplicationEvent;

import br.com.expertpeticoes.curso.model.form.EmailPromocional;

public class EmailEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	
	private EmailPromocional email;

	public EmailEvent(Object source, EmailPromocional email) {
		super(source);
		this.email = email;
	}
	
	public EmailPromocional getEmail() {
		return this.email;
	}
	
}
