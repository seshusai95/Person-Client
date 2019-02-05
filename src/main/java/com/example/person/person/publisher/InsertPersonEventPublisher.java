package com.example.person.person.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import com.example.person.person.events.InsertPersonEvent;

@Component
public class InsertPersonEventPublisher {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	
	public void publish() {
		InsertPersonEvent insertPersonEvent = new InsertPersonEvent(this);
		System.out.println("This is InsertPersonEvent Publisher");
		applicationEventPublisher.publishEvent(insertPersonEvent);
	}
}
