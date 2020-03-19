package com.person.model;

import java.util.List;

public interface PS {

	//추가
	public void insert(PVO pvo);
	
	//전체보기
	public List<PVO> list();
	
	//상세보기
	public PVO detail(String id);
	
	//수정
	public void update(PVO pvo);
	
	//삭제
	public void delete(String id);
	
}
