package com.example.person.person.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.person.model.Person;
import com.example.person.person.service.PersonService;

@RestController
@CrossOrigin
public class PersonController {

	org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonService personService;
	
	@PostMapping("/persons")
	public HttpStatus insertPersons(@RequestBody Person person) {
		logger.info("Person object {}", person);
		return personService.insertIntoPersonDao(person);
	}
	
	@GetMapping("/persons")
	public List<Person> displayPersons() {
		return personService.getPersonsFromDao();
	}
	
	@GetMapping("/persons/{id}")
	public Person getPerson(@PathVariable int id) {
		return personService.getPersonFromDao(id);
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable int id) {
		 personService.deletePersonFromDao(id);
	}
	
}
