package com.example.person.person.dao;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.person.person.model.Person;


public interface PersonDao {

	void insertIntoDb(Person person);
//	void getPersonsFromDb();
//	void getPersonFromDb(int id);
//	void deleteFromDb(int id);
//	void updatePersonInDb(int id, long phone);
//	void insertIntoClientDb(Person person);
}
