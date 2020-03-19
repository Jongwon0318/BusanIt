package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO{
	
	@Autowired
	private JdbcTemplate template;
		
	@Override
	public void person_insert(PersonVO person) {
		
		String sql="INSERT INTO PERSON VALUES(?,?,?,?,?)";
		Object[] param=new Object[] {
			person.getId(),
			person.getPassword(),
			person.getName(),
			person.getGender(),
			person.getJob()
		};
		
		template.update(sql, param);
		System.out.println("PERSON 추가 완료");
	}

	@Override
	public List<PersonVO> person_list() {
		String sql="SELECT * FROM PERSON";
		List<PersonVO> list=template.query(sql, new RowMapper<PersonVO>() {
			@Override
			public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonVO person=new PersonVO();
				
				person.setId(rs.getString("id"));
				person.setPassword(rs.getString("password"));
				person.setName(rs.getString("name"));
				person.setGender(rs.getString("gender"));
				person.setJob(rs.getString("job"));
				
				return person;
			}
		});
		return list;
	}

	@Override
	public PersonVO person_view(String id) {
		String sql="SELECT * FROM PERSON WHERE ID='"+id+"'";
		PersonVO person=template.queryForObject(sql, new RowMapper<PersonVO>() {
			@Override
			public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonVO person=new PersonVO();
				
				person.setId(rs.getString("id"));
				person.setPassword(rs.getString("password"));
				person.setName(rs.getString("name"));
				person.setGender(rs.getString("gender"));
				person.setJob(rs.getString("job"));
				
				return person;
			}
		});
		return person;
	}

	@Override
	public void person_update(PersonVO person) {
		String sql="UPDATE PERSON SET id=?, password=?, name=?, gender=?, job=? WHERE ID='"+person.getId()+"'";
		Object[] param=new Object[] {
			person.getId(),
			person.getPassword(),
			person.getName(),
			person.getGender(),
			person.getJob()
		};
		template.update(sql, param);
		System.out.println(person.getId()+" 회원 수정 완료");
	}

	@Override
	public void person_delete(String id) {
		String sql="DELETE FROM PERSON WHERE ID='"+id+"'";
		template.execute(sql);
		System.out.println(id+" 회원 삭제 완료");
	}

}
