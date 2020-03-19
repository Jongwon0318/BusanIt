package com.person.model;

import java.util.List;

public interface PersonDAO {

	//�߰�
	public void personInsert(PersonDTO user);
	
	//��ü����
	public List<PersonDTO> personList();
	
	//�󼼺���
	public PersonDTO personView(String id);
	
	//����
	public void personUpdate(PersonDTO user);
	
	//����
	public void personDelete(String id);
	
}
