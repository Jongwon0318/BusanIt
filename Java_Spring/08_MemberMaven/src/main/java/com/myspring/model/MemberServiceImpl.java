package com.myspring.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl dao;
	
	@Override
	public void insert(MemberVO member) {
		dao.dao_insert(member);
	}

	@Override
	public List<MemberVO> list(String field, String data) {
		return dao.dao_list();
	}

	@Override
	public MemberVO view(String id) {
		return dao.dao_view(id);
	}

	@Override
	public void update(MemberVO member) {
		dao.dao_update(member);
	}

	@Override
	public void delete(String id) {
		dao.dao_delete(id);
	}

}
