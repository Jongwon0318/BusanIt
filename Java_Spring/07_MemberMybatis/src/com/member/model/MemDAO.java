package com.member.model;

import java.util.List;

public interface MemDAO {
	
	//추가
	public void dao_insert(String idName, MemberVO member);
	
	//전체보기
	public List<MemberVO> dao_list(String idName);
	
	//상세보기
	public MemberVO dao_view(String idName, String id);
	
	//수정
	public void dao_update(String idName, MemberVO member);
	
	//삭제
	public void dao_delete(String idName, String id);
}
