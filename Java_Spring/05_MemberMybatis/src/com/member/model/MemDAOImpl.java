package com.member.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.member.config.MybatisManager;

@Repository("mDao")
public class MemDAOImpl implements MemDAO {

	SqlSession sqlMap;

	public MemDAOImpl() {
		SqlSessionFactory sqlMapper = MybatisManager.getMapper();
		sqlMap = sqlMapper.openSession();
	}

	@Override
	public void dao_insert(String idName, MemberVO member) {
		sqlMap.insert(idName,member);
		sqlMap.commit();
	}

	@Override
	public List<MemberVO> dao_list(String idName) {
		List<MemberVO> memList=sqlMap.selectList(idName);
		return memList;
	}

	@Override
	public MemberVO dao_view(String idName, String id) {
		return sqlMap.selectOne(idName, id);
	}

	@Override
	public void dao_update(String idName, MemberVO member) {
		sqlMap.update(idName, member);
		sqlMap.commit();
	}

	@Override
	public void dao_delete(String idName, String id) {
		sqlMap.delete(idName, id);
		sqlMap.commit();
	}

}
