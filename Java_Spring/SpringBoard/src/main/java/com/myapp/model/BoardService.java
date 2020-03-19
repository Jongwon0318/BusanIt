package com.myapp.model;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
	
	//추가
	public void insert(BoardVO board);
	
	//수정
	public void update(BoardVO board);
	
	//삭제
	public void delete(int num);
	
	//목록
	public List<BoardVO> list(HashMap<String,Object> hm);
	
	//상세보기
	public BoardVO detail(int num);
	
	//카운트
	public int count(HashMap<String, Object> hm);
	
	//조회수
	public int hitCount(int num);
}
