package com.member.model;

import java.util.List;

public interface MemberDAO {
	
	//전체보기
		List<MemberVO> getMemberList();
		
	//상세보기
		MemberVO findById(String id);
		
	//추가
		void insert(MemberVO user);
		
	//수정
		void update(MemberVO user);
		
	//삭제
		void delete(String id);
}
