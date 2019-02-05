package com.example.person.person.events;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent{

	public CustomEvent(Object source) {
		super(source);
	}
	
	public String getMessage(){
	      return "This is Custom Event";
	   }
}
