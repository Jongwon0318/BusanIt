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
	
	//댓글추가
	public void dao_addComment(CommentVO comment);
	
	//댓글목록
	public List<CommentVO> dao_getComments(int bnum);
	
	//댓글삭제
	public void dao_commentDelete(int cnum);
	
	//댓글반환
	public CommentVO dao_commentDetail(int cnum);
}
