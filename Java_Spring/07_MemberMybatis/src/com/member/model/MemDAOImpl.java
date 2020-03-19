package com.member.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mDao")
public class MemDAOImpl implements MemDAO {

	@Autowired
	private SqlSessionFactory sqlMapper;
	

	@Override
	public void dao_insert(String idName, MemberVO member) {
		SqlSession sess
		=sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(idName,member);
		sess.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		SqlSession sess
		=sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> memList=sess.selectList(idName);
		return memList;
	}

	@Override
	public MemberVO dao_view(String idName, String id) {
		SqlSession sess
		=sqlMapper.openSession(ExecutorType.REUSE);
		return sess.selectOne(idName, id);
	}

	@Override
	public void dao_update(String idName, MemberVO member) {
		SqlSession sess
		=sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(idName, member);
		sess.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		SqlSession sess
		=sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(idName, id);
		sess.commit();
	}

}
