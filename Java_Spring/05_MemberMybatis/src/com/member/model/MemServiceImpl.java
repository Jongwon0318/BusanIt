package com.member.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("mService")
public class MemServiceImpl implements MemService{

	@Resource(name="mDao")
	private MemDAOImpl mDao;
	
	@Override
	public void insert(MemberVO member) {
		mDao.dao_insert("insertData", member);
	}

	@Override
	public List<MemberVO> list() {
		return mDao.dao_list("listData");
	}

	@Override
	public MemberVO detail(String id) {
		return mDao.dao_view("selectOneData", id);
	}

	@Override
	public void update(MemberVO member) {
		mDao.dao_update("updateData", member);
	}

	@Override
	public void delete(String id) {
		mDao.dao_delete("deleteData", id);
	}

}
