package com.myspring.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionFactory sqlMapper;
	
	@Override
	public void dao_insert(String idName,MemberVO member) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(idName, member);
		sess.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		SqlSession sess= sqlMapper.openSession(ExecutorType.REUSE);
		return sess.selectList(idName);
	}
	
	@Override
	public List<MemberVO> dao_searchList(String idName,HashMap<String,String> map){
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		return sess.selectList(idName, map);
	}

	@Override
	public MemberVO dao_detail(String idName,String id) {
		SqlSession sess= sqlMapper.openSession(ExecutorType.REUSE);
		return sess.selectOne(idName,id);
	}

	@Override
	public void dao_update(String idName,MemberVO member) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(idName,member);
		sess.commit();		
	}

	@Override
	public void dao_delete(String idName,String id) {
		SqlSession sess=sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(idName,id);
		sess.commit();
	}

}
