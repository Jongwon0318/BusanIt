package com.person.model;

import java.util.List;

public interface PS {

	//�߰�
	public void insert(PVO pvo);
	
	//��ü����
	public List<PVO> list();
	
	//�󼼺���
	public PVO detail(String id);
	
	//����
	public void update(PVO pvo);
	
	//����
	public void delete(String id);
	
}
