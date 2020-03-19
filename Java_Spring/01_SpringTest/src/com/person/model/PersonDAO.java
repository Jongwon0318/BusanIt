package com.person.model;

import java.util.List;

public interface PersonDAO {

	//추가
	public void personInsert(PersonDTO user);
	
	//전체보기
	public List<PersonDTO> personList();
	
	//상세보기
	public PersonDTO personView(String id);
	
	//수정
	public void personUpdate(PersonDTO user);
	
	//삭제
	public void personDelete(String id);
	
}
