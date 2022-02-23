package br.com.expertpeticoes.curso.email.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class publisherEmail implements ApplicationEventPublisherAware{

	@Autowired
	private ApplicationEventPublisher publisher;

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
	public void publish(EmailEvent event) {
		this.publisher.publishEvent(event);
	}
	
}
