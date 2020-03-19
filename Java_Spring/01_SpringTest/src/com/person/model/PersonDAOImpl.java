package com.person.model;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDAOImpl implements PersonDAO{

	private JdbcTemplate template;
	
	//setter
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	@Override
	public void personInsert(PersonDTO user) {
		String sql="INSERT INTO PERSON VALUES (?,?,?,?,?)";
		Object[] param=new Object[] {
			user.getId(),
			user.getPassword(),
			user.getName(),
			user.getGender(),
			user.getJob()
		};
		template.update(sql,param);
		template.update("COMMIT");
		System.out.println("1명 추가 완료");
	}

	@Override
	public List<PersonDTO> personList() {
		String sql="SELECT * FROM PERSON";
		List<PersonDTO> list=template.query(sql, new PersonRowMapper());
		return list;
	}

	@Override
	public PersonDTO personView(String id) {
		String sql="SELECT * FROM PERSON WHERE ID='"+id+"'";
		PersonDTO user=template.queryForObject(sql, new PersonRowMapper());
		return user;
	}

	@Override
	public void personUpdate(PersonDTO user) {
		String sql="UPDATE PERSON SET password=?,name=?,job=?,gender=? WHERE ID='"+user.getId()+"'";
		Object[] param=new Object[] {
			user.getPassword(),
			user.getName(),
			user.getJob(),
			user.getGender()
		};
		template.update(sql, param);
		template.update("COMMIT");
		System.out.println(user.getId()+" 회원 수정 완료");
	}

	@Override
	public void personDelete(String id) {
		String sql="DELETE FROM PERSON WHERE ID ='"+id+"'";
		template.execute(sql);
		template.update("COMMIT");
		System.out.println(id+" 회원 삭제 완료");
	}

}
