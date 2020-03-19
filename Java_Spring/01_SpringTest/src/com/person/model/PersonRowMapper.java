package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonRowMapper implements RowMapper<PersonDTO>{

	@Override
	public PersonDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PersonDTO user=new PersonDTO();
		
		user.setId(rs.getString("id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setGender(rs.getString("gender"));
		user.setJob(rs.getString("job"));
		
		return user;
	}

}
