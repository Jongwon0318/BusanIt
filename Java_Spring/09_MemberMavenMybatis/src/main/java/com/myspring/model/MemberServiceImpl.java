package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAOImpl dao;
	
	@Override
	public void insert(MemberVO member) {
		dao.dao_insert("insert",member);		
	}

	@Override
	public List<MemberVO> list() {
		return dao.dao_list("list");
	}
	
	@Override
	public List<MemberVO> searchList(String field,String data){
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("field", field);
		map.put("data", data);
		return dao.dao_searchList("searchList",map);
	}

	@Override
	public MemberVO detail(String id) {
		return dao.dao_detail("detail",id);
	}

	@Override
	public void update(MemberVO member) {
		dao.dao_update("update",member);
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("delete",id);
	}

}
