package com.person.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.person.config.MybatisManager;

@Repository
public class PDAOImpl implements PDAO{
	
	SqlSession sqlMap;
	
	public PDAOImpl() {
		SqlSessionFactory sqlMapper=MybatisManager.getMapper();
		sqlMap=sqlMapper.openSession();
	}

	@Override
	public void dao_insert(String idName, PVO pvo) {
		sqlMap.insert(idName, pvo);
	}

	@Override
	public List<PVO> dao_list(String idName) {
		return sqlMap.selectList(idName);
	}

	@Override
	public PVO dao_detail(String idName, String id) {
		return sqlMap.selectOne(idName, id);
	}

	@Override
	public void dao_update(String idName, PVO pvo) {
		sqlMap.update(idName, pvo);
	}

	@Override
	public void dao_delete(String idName, String id) {
		sqlMap.delete(idName, id);
	}

}
