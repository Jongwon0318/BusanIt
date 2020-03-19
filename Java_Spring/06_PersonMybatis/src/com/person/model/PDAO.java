package com.person.model;

import java.util.List;

public interface PDAO {
	
	//�߰�
	public void dao_insert(String idName,PVO pvo);
	
	//��ü����
	public List<PVO> dao_list(String idName);
	
	//�󼼺���
	public PVO dao_detail(String idName, String id);
	
	//����
	public void dao_update(String idName, PVO pvo);
	
	//����
	public void dao_delete(String idName, String id);
	
}
