package com.myapp.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myapp.mapper.BoardMapper;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired
	private BoardMapper mapper;

	@Override
	public void dao_insert(BoardVO board) {
		//System.out.println("dao : "+board.toString());
		mapper.insert(board);
	}

	@Override
	public void dao_update(BoardVO board) {
		mapper.update(board);
	}

	@Override
	public void dao_delete(int num) {
		mapper.delete(num);
	}

	@Override
	public List<BoardVO> dao_list(HashMap<String, Object> hm) {
		return mapper.list(hm);
	}

	@Override
	public BoardVO dao_detail(int num) {
		return mapper.detail(num);
	}

	@Override
	public int dao_count(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}

	@Override
	public int dao_hitCount(int num) {
		return mapper.hitCount(num);
	}

	@Override
	public void dao_addComment(CommentVO comment) {
		mapper.addComment(comment);		
	}

	@Override
	public List<CommentVO> dao_getComments(int bnum) {
		return mapper.getComments(bnum);
	}

	@Override
	public void dao_commentDelete(int cnum) {
		mapper.commentDelete(cnum);
	}

	@Override
	public CommentVO dao_commentDetail(int cnum) {
		return mapper.commentDetail(cnum);
	}
}
