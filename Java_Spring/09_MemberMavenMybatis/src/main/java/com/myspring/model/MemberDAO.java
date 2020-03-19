package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
	
	//�߰�
	public void dao_insert(String idName,MemberVO member);
	
	//��ü����
	public List<MemberVO> dao_list(String idName);
	
	//�˻�����
	public List<MemberVO> dao_searchList(String idName, HashMap<String,String> map);
	
	//�󼼺���
	public MemberVO dao_detail(String idName,String id);
	
	//����
	public void dao_update(String idName,MemberVO member);
	
	//����
	public void dao_delete(String idName,String id);
	
}
