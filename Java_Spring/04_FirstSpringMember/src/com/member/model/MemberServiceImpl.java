package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("service")
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl dao;
	
	@Override
	public void insert(MemberVO member) {
		dao.insert(member);
	}

	@Override
	public List<MemberVO> list() {
		return dao.getMemberList();
	}

	@Override
	public MemberVO detail(String id) {
		return dao.findById(id);
	}

	@Override
	public void update(MemberVO member) {
		dao.update(member);
	}

	@Override
	public void delete(String id) {
		dao.delete(id);
	}

}
