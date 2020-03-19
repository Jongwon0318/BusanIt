package com.myspring.model;

import java.util.List;

public interface MemberDAO {
	
	//�߰�
	public void dao_insert(MemberVO member);
	
	//��ü����
	public List<MemberVO> dao_list();
	
	//�󼼺���
	public MemberVO dao_view(String id);
	
	//����
	public void dao_update(MemberVO member);
	
	//����
	public void dao_delete(String id);
	

}
