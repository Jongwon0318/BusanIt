package com.member.model;

import java.util.List;

public interface MemberDAO {
	
	//전체보기
		List<MemberDTO> getMemberList();
	//상세보기
		MemberDTO findById(String id);
	//추가
		void insert(MemberDTO user);
	//수정
		void update(MemberDTO user);
	//삭제
		void delete(String id);
}
