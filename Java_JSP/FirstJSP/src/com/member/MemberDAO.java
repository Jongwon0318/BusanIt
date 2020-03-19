package com.member;

import java.util.ArrayList;

public interface MemberDAO {
	
	//�߰�
	public void memberInsert(MemberVO vo);
	
	//��ü����
	public ArrayList<MemberVO> memberLIst();
	
	//����
	public int memberUpdate(MemberVO vo);
	
	//�󼼺���
	public MemberVO memberView(String userid);
	
	//����
	public void memberDel(String userid);
	
	//���̵�üũ
	public String idCheck(String userid);
	
}