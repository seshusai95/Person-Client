package com.example.person.person.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.person.person.dao.PersonDao;
import com.example.person.person.model.Person;
import com.example.person.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDao personDao;
	
	@Override
	public HttpStatus insertIntoPersonDao(Person person) {
	return personDao.insertIntoDb(person);	
		
	}

	@Override
	public List<Person> getPersonsFromDao() {
		return  personDao.getPersonsFromDb();
	}

	@Override
	public Person getPersonFromDao(int id) {
		return personDao.getPersonFromDb(id);
	}

	@Override
	public void deletePersonFromDao(int id) {
		personDao.deleteFromDb(id);
		
	}

	
}
