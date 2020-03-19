package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.person.vo.PersonVO;

@Repository
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SqlSession sqlMap;
	
	@Override
	public void dao_insert(String idName, PersonVO person) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.insert(idName,person);
		sqlMap.commit();
	}

	@Override
	public List<PersonVO> dao_list(String idName, HashMap<String,String> map) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectList(idName,map);
	}

//	@Override
//	public List<PersonVO> dao_searchList(String idName, HashMap<String, String> map) {
////		System.out.println("ÇØ½¬¸Ê null¿©ºÎ"+map.isEmpty());
////		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
//		return sqlMap.selectList(idName,map);
//	}
	
	@Override
	public PersonVO dao_detail(String idName, String id) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		return sqlMap.selectOne(idName,id);
	}

	@Override
	public void dao_update(String idName, PersonVO person) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.update(idName,person);
		sqlMap.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		sqlMap.delete(idName,id);
		sqlMap.commit();
	}

	@Override
	public int dao_count(String idName, HashMap<String,String> map) {
//		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
		int count=sqlMap.selectOne(idName,map);
		return count;
	}

//	@Override
//	public int dao_searchCount(String idName, HashMap<String, String> map) {
////		SqlSession sqlMap=sqlMapper.openSession(ExecutorType.REUSE);
//		int count=sqlMap.selectOne(idName, map);
//		return count;
//	}




}
