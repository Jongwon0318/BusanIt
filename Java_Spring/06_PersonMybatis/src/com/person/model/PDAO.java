package com.person.model;

import java.util.List;

public interface PDAO {
	
	//추가
	public void dao_insert(String idName,PVO pvo);
	
	//전체보기
	public List<PVO> dao_list(String idName);
	
	//상세보기
	public PVO dao_detail(String idName, String id);
	
	//수정
	public void dao_update(String idName, PVO pvo);
	
	//삭제
	public void dao_delete(String idName, String id);
	
}
