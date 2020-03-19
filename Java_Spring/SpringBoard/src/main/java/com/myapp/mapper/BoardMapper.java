package com.myapp.mapper;

import java.util.HashMap;
import java.util.List;

import com.myapp.model.BoardVO;

public interface BoardMapper {

	public void insert(BoardVO board);
	
	public List<BoardVO> list(HashMap<String,Object> hm);
	
	public BoardVO detail(int num);
	
	public void update(BoardVO board);
	
	public void delete(int num);
	
	public int count(HashMap<String,Object> hm);
	
	public int hitCount(int num);
}
