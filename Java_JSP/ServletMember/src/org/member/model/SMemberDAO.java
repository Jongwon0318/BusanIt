package org.member.model;

import java.util.ArrayList;

public interface SMemberDAO {
	//�߰�
		public void memInsert(MemberDTO mdto);
	//��ü����
		public ArrayList<MemberDTO> memList();
	//����
		public void memUpdate(MemberDTO mdto);
	//����
		public void memDelete(String userid);
	//�󼼺���
		public MemberDTO memView(String userid);
}
