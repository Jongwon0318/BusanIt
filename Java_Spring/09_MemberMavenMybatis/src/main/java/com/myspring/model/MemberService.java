package com.myspring.model;

import java.util.List;

public interface MemberService {
	
	//추가
	public void insert(MemberVO member);
	
	//전체보기
	public List<MemberVO> list();
	
	//검색리스트
	public List<MemberVO> searchList(String field,String data);
	
	//상세보기
	public MemberVO detail(String id);
	
	//수정
	public void update(MemberVO member);
	
	//삭제
	public void delete(String id);
	
}
