package com.member.model;

import java.util.List;

public interface MemberService {
	//�߰�
	public void insert(MemberVO member);
	
	//��ü����
	public List<MemberVO> list();
	
	//�󼼺���
	public MemberVO detail(String id);
	
	//����
	public void update(MemberVO member);
	
	//����
	public void delete(String id);
}
