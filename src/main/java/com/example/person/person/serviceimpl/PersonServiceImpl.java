package com.example.person.person.serviceimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.person.person.dao.PersonDao;
import com.example.person.person.model.Person;
import com.example.person.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	private String mappingUri = "http://localhost:8081/persons";
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	@Qualifier("restTemplate")
	RestTemplate restTemplate;
	
	@Override
	public HttpStatus insertIntoPersonDao(Person person) {
	personDao.insertIntoDb(person);			
	ResponseEntity<HttpStatus> response = restTemplate.postForEntity(mappingUri, person, HttpStatus.class);
	return response.getStatusCode();
	}

	@Override
	public List<Person> getPersonsFromDao() {
	   // personDao.getPersonsFromDb();
		return Arrays.asList(restTemplate.getForObject(mappingUri, Person[].class));
	}

	@Override
	public Person getPersonFromDao(int id) {
	   // personDao.getPersonFromDb(id);
		return restTemplate.getForObject(mappingUri + "/{ id }", Person.class, id);
	}

	@Override
	public HttpStatus deletePersonFromDao(int id) {
		 // personDao.deleteFromDb(id);
		  restTemplate.delete(mappingUri + "/{ id }", id);
		  if(null!=restTemplate.getForObject(mappingUri + "/{ id }", Person.class, id)){
			  return HttpStatus.BAD_REQUEST;
		  }else {
			  return HttpStatus.OK;
		  }

	}
	
	@Override
	public Person updatePersonFromDao(int id,long phone) {
	    //personDao.updatePersonInDb(id,phone);
		return restTemplate.patchForObject(mappingUri +"/{id}"+ "/{phone}", Person.class, Person.class,id,phone);
	}

	
}
