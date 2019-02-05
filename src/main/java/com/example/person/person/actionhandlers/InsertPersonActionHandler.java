package com.example.person.person.actionhandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.person.person.dao.PersonDao;
import com.example.person.person.events.InsertPersonEvent;

@Component
public class InsertPersonActionHandler implements ApplicationListener<InsertPersonEvent>{

	@Autowired
	PersonDao PersonDao;
	@Override
	public void onApplicationEvent(InsertPersonEvent event) {
		System.out.println("Recieved message from insert person event");	
		
		//PersonDao.insertIntoDb(person);
	}
	
}
