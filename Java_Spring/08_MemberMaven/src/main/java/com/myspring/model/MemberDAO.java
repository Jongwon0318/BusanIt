package com.myspring.model;

import java.util.List;

public interface MemberDAO {
	
	//추가
	public void dao_insert(MemberVO member);
	
	//전체보기
	public List<MemberVO> dao_list();
	
	//상세보기
	public MemberVO dao_view(String id);
	
	//수정
	public void dao_update(MemberVO member);
	
	//삭제
	public void dao_delete(String id);
	

}
