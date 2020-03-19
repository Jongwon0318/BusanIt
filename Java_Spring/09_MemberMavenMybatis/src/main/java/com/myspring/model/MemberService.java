package com.myspring.model;

import java.util.List;

public interface MemberService {
	
	//�߰�
	public void insert(MemberVO member);
	
	//��ü����
	public List<MemberVO> list();
	
	//�˻�����Ʈ
	public List<MemberVO> searchList(String field,String data);
	
	//�󼼺���
	public MemberVO detail(String id);
	
	//����
	public void update(MemberVO member);
	
	//����
	public void delete(String id);
	
}
