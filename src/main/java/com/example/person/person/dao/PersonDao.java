package com.example.person.person.dao;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.person.person.model.Person;


public interface PersonDao {

	HttpStatus insertIntoDb(Person person);
	List<Person> getPersonsFromDb();
	Person getPersonFromDb(int id);
	void deleteFromDb(int id);
}
