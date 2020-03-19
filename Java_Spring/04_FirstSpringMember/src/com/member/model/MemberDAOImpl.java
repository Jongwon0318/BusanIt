package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<MemberVO> getMemberList() {
		String sql="SELECT * FROM SPRINGMEMBER";
		List<MemberVO> list=template.query(sql, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO user=new MemberVO();
				user.setAddr(rs.getString("addr"));
				user.setId(rs.getString("id"));
				user.setMemo(rs.getString("memo"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setReg_date(rs.getString("reg_Date"));
				return user;
			}
		});
		return list;
	}

	@Override
	public MemberVO findById(String id) {
		String sql="SELECT * FROM SPRINGMEMBER WHERE ID='"+id+"'";
		MemberVO user=template.queryForObject(sql,new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO user=new MemberVO();
				user.setAddr(rs.getString("addr"));
				user.setId(rs.getString("id"));
				user.setMemo(rs.getString("memo"));
				user.setName(rs.getString("name"));
				user.setPass(rs.getString("pass"));
				user.setReg_date(rs.getString("reg_Date"));
				return user;
			}
		});
		return user;
	}

	@Override
	public void insert(MemberVO user) {
		String sql="INSERT INTO SPRINGMEMBER VALUES (?,?,?,?,?,SYSDATE)";
		Object[] param=new Object[] {
			user.getId(), user.getPass(), user.getName(), user.getAddr(), user.getMemo()
		};
		template.update(sql, param);
		System.out.println("MEMBER 등록 완료");
	}

	@Override
	public void update(MemberVO user) {
		String sql="UPDATE SPRINGMEMBER SET pass=?, name=?, addr=?, memo=? WHERE ID='"+user.getId()+"'";
		Object[] param=new Object[] {
			user.getPass(), user.getName(), user.getAddr(), user.getMemo()	
		};
		template.update(sql, param);
		System.out.println(user.getId()+" 회원 수정 완료");
	}

	@Override
	public void delete(String id) {
		String sql="DELETE FROM SPRINGMEMBER WHERE ID='"+id+"'";
		template.update(sql);
		System.out.println(id+" 회원 삭제 완료");
	}

}
