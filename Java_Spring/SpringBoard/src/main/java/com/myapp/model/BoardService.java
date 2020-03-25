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
	
	//댓글추가
	public void addComment(CommentVO comment);
	
	//댓글목록
	public List<CommentVO> getComments(int bnum);
	
	//댓글삭제
	public void commentDelete(int cnum);
	
	//댓글반환
	public CommentVO commentDetail(int cnum);
}
