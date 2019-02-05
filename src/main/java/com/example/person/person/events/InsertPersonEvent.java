package com.example.person.person.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.person.person.dao.PersonDao;
import com.example.person.person.model.Person;


public class InsertPersonEvent extends ApplicationEvent{

//	@Autowired
//	PersonDao personDao;
	
	public InsertPersonEvent(Object source) {
		super(source);
	}
	
	public void insertIntoPersonDao(Person person) {
	//personDao.insertIntoClientDb(person);
		
	}

}
