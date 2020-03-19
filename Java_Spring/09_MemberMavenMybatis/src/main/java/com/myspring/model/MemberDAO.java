package com.myspring.model;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
	
	//추가
	public void dao_insert(String idName,MemberVO member);
	
	//전체보기
	public List<MemberVO> dao_list(String idName);
	
	//검색보기
	public List<MemberVO> dao_searchList(String idName, HashMap<String,String> map);
	
	//상세보기
	public MemberVO dao_detail(String idName,String id);
	
	//수정
	public void dao_update(String idName,MemberVO member);
	
	//삭제
	public void dao_delete(String idName,String id);
	
}
