package com.example.person.person.daoimpl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
	private String updatePerson = "update persons set phone=:phone where id=:id";
	
	@Autowired
	NamedParameterJdbcTemplate personTemplate;
	
	@Override
	public void insertIntoDb(Person person) {
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("name", person.getName());
		mapSqlParameterSource.addValue("age", person.getAge());
		mapSqlParameterSource.addValue("city", person.getCity());
		mapSqlParameterSource.addValue("phone", person.getPhone());
		personTemplate.update(insertQuery, mapSqlParameterSource);
	}

//	@Override
//	public void getPersonsFromDb() {
//		 personTemplate.query(getAllPersons, new PersonMapper());
//	}

//	@Override
//	public void getPersonFromDb(int id) {
//		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		mapSqlParameterSource.addValue("id", id);
//		personTemplate.queryForObject(getPerson,mapSqlParameterSource, new PersonMapper());
//		
//		
//	}

//	@Override
//	public void deleteFromDb(int id) {
//	 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//	 mapSqlParameterSource.addValue("id", id);
//	 personTemplate.update(deletePerson, mapSqlParameterSource);
//	 	  
//	}
//	
//	@Override
//	public void updatePersonInDb(int id,long phone) {
//		Person person = new Person();
//		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		mapSqlParameterSource.addValue("id", person.getId());
//		mapSqlParameterSource.addValue("phone", person.getPhone());
//		personTemplate.update(updatePerson, mapSqlParameterSource);
//	}
}
