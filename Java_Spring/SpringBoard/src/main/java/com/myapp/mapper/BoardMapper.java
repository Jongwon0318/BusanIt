package com.myapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.myapp.model.BoardVO;
import com.myapp.model.CommentVO;

public interface BoardMapper {

	public void insert(BoardVO board);
	
	public List<BoardVO> list(HashMap<String,Object> hm);
	
	public BoardVO detail(int num);
	
	public void update(BoardVO board);
	
	public void delete(int num);
	
	public int count(HashMap<String,Object> hm);
	
	public int hitCount(int num);
	
	public void addComment(CommentVO comment);
	
	public List<CommentVO> getComments(int bnum);
	
	public void commentDelete(int cnum);
	
	public CommentVO commentDetail(int cnum);
}
