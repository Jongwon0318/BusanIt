package com.person.model;

import java.util.List;

import com.person.vo.PersonVO;

public interface PersonService {

	public void insert(PersonVO person);
	
	public List<PersonVO> list(String field,String word);
	
	public PersonVO detail(String id);
	
	public void update(PersonVO person);
	
	public void delete(String id);
	
	public int count(String field,String world);
}
