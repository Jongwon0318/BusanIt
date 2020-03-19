package com.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PSImpl implements PS{
	
	@Autowired
	private PDAOImpl dao;

	@Override
	public void insert(PVO pvo) {
		dao.dao_insert("pInsert", pvo);
	}

	@Override
	public List<PVO> list() {
		return dao.dao_list("pList");
	}

	@Override
	public PVO detail(String id) {
		return dao.dao_detail("pDetail", id);
	}

	@Override
	public void update(PVO pvo) {
		dao.dao_update("pUpdate", pvo);		
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("pDelete", id);
	}

}
