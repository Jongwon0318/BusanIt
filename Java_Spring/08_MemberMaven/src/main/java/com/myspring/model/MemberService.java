package com.myspring.model;

import java.util.List;

public interface MemberService {
		
	//�߰�
	public void insert(MemberVO member);
	
	//��ü����
	public List<MemberVO> list(String field,String data);
	
	//�󼼺���
	public MemberVO view(String id);
	
	//����
	public void update(MemberVO member);
	
	//����
	public void delete(String id);
	
}
