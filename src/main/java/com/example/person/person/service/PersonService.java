package com.example.person.person.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.person.person.model.Person;

public interface PersonService {

	HttpStatus insertIntoPersonDao(Person person);
	List<Person> getPersonsFromDao();
	Person getPersonFromDao(int id);
	void deletePersonFromDao(int id);
}
