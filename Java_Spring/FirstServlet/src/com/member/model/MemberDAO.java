package com.member.model;

import java.util.ArrayList;

public interface MemberDAO {
	
	//��ü����
		ArrayList<MemberDTO> getMemberList();
	//�󼼺���
		MemberDTO findById(String id);
	//�߰�
		void insert(MemberDTO user);
	//����
		void update(MemberDTO user);
	//����
		void delete(String id);
}
