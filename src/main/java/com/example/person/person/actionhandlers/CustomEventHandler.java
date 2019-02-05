package com.example.person.person.actionhandlers;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.person.person.events.CustomEvent;

@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent>{

	@Override
	public void onApplicationEvent(CustomEvent event) {
	System.out.println("Recieved message from custom event - "+event.getMessage());	
	}
}
