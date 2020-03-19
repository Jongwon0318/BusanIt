package com.myapp.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOImpl dao;

	@Override
	public void insert(BoardVO board) {
		//System.out.println("Service : "+board.toString());
		dao.dao_insert(board);		
	}

	@Override
	public void update(BoardVO board) {
		dao.dao_update(board);
	}

	@Override
	public void delete(int num) {
		dao.dao_delete(num);
	}

	@Override
	public List<BoardVO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	@Override
	public BoardVO detail(int num) {
		return dao.dao_detail(num);
	}

	@Override
	public int count(HashMap<String, Object> hm) {
		return dao.dao_count(hm);
	}

	@Override
	public int hitCount(int num) {
		return dao.dao_hitCount(num);
	}
	
}
