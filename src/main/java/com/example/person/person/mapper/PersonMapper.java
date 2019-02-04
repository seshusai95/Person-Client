package com.example.person.person.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.person.person.model.Person;

public class PersonMapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
	Person person = new Person();
	person.setId(rs.getInt("id"));
	person.setName(rs.getString("name"));
	person.setAge(rs.getInt("age"));
	person.setCity(rs.getString("city"));
	person.setPhone(rs.getLong("phone"));
		return person;
	}

}
