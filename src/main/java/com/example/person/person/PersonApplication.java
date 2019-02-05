package com.example.person.person;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.person.person.publisher.InsertPersonEventPublisher;

@SpringBootApplication
public class PersonApplication {
	
//	@Autowired
//	private InsertPersonEventPublisher personEventPublisher;
	
	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);		
	}
//	@PostConstruct
//	public  void execute() {
//		personEventPublisher.publish();	
//	}

}

