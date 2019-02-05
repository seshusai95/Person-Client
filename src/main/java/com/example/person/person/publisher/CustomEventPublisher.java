package com.example.person.person.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.client.MultipartBodyBuilder.PublisherEntity;
import org.springframework.stereotype.Component;

import com.example.person.person.events.CustomEvent;

@Component
public class CustomEventPublisher{

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	
	public void publish() {
		CustomEvent customEvent = new CustomEvent(this);
		System.out.println("This is Event Publisher");
		applicationEventPublisher.publishEvent(customEvent);
	}

}
