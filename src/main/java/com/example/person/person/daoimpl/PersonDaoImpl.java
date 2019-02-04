package com.example.person.person.daoimpl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.example.person.person.dao.PersonDao;
import com.example.person.person.mapper.PersonMapper;
import com.example.person.person.model.Person;

@Repository
public class PersonDaoImpl implements PersonDao{

	private String insertQuery = "insert into persons (name,age,city,phone) values (:name,:age,:city,:phone)";
	private String getAllPersons = "select id, name, age, city, phone from persons";
	private String getPerson = "select id, name, age, city, phone from persons where id=:id";
	private String deletePerson = "delete from persons where id=:id";
	
	private String mappingUri = "http://10.11.178.247:8080/persons";
//	@Autowired
//	NamedParameterJdbcTemplate personTemplate;
	
	@Autowired
	@Qualifier("restTemplate")
	RestTemplate restTemplate;
	
	@Override
	public HttpStatus insertIntoDb(Person person) {
		ResponseEntity<HttpStatus> response = restTemplate.postForEntity(mappingUri, person, HttpStatus.class);
		return response.getBody();
//		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		mapSqlParameterSource.addValue("name", person.getName());
//		mapSqlParameterSource.addValue("age", person.getAge());
//		mapSqlParameterSource.addValue("city", person.getCity());
//		mapSqlParameterSource.addValue("phone", person.getPhone());
//		personTemplate.update(insertQuery, mapSqlParameterSource);
	}

	@Override
	public List<Person> getPersonsFromDb() {
		return Arrays.asList(restTemplate.getForObject(mappingUri, Person[].class)); //personTemplate.query(getAllPersons, new PersonMapper());
	}

	@Override
	public Person getPersonFromDb(int id) {
//		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		mapSqlParameterSource.addValue("id", id);
		//personTemplate.queryForObject(getPerson,mapSqlParameterSource, new PersonMapper());
		return restTemplate.getForObject(mappingUri + "/{ id }", Person.class, id);
		
	}

	@Override
	public void deleteFromDb(int id) {
//	 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//	 mapSqlParameterSource.addValue("id", id);
	 //personTemplate.update(deletePerson, mapSqlParameterSource);
	  restTemplate.delete(mappingUri + "/{ id }", id);
	}
}
