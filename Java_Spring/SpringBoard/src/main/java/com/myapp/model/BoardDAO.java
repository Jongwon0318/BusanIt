package com.myapp.model;

import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
	
	//추가
	public void dao_insert(BoardVO board);
	
	//수정
	public void dao_update(BoardVO board);
	
	//삭제
	public void dao_delete(int num);
	
	//목록
	public List<BoardVO> dao_list(HashMap<String,Object> hm);
	
	//상세보기
	public BoardVO dao_detail(int num);
	
	//카운트
	public int dao_count(HashMap<String, Object> hm);
	
	//조회수
	public int dao_hitCount(int num);
}
