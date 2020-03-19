package com.myspring.model;

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
	public void dao_insert(MemberVO member) {
		String sql="INSERT INTO SPRINGMEMBER VALUES (?,?,?,?,?,SYSDATE)";
		Object[] param=new Object[] {
				member.getId(), member.getPass(), member.getName(), member.getAddr(), member.getMemo()
		};
		template.update(sql, param);
		template.update("COMMIT");
	}

	@Override
	public List<MemberVO> dao_list() {
		String sql="SELECT * FROM SPRINGMEMBER";
		return template.query(sql, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO member=new MemberVO();
				member.setAddr(rs.getString("addr"));
				member.setId(rs.getString("id"));
				member.setMemo(rs.getString("memo"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
	}

	@Override
	public MemberVO dao_view(String id) {
		String sql="SELECT * FROM SPRINGMEMBER WHERE ID='"+id+"'";
		return template.queryForObject(sql, new RowMapper<MemberVO>() {
			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO member=new MemberVO();
				member.setAddr(rs.getString("addr"));
				member.setId(rs.getString("id"));
				member.setMemo(rs.getString("memo"));
				member.setName(rs.getString("name"));
				member.setPass(rs.getString("pass"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
	}

	@Override
	public void dao_update(MemberVO member) {
		String sql="UPDATE SPRINGMEMBER SET pass=?, name=?, addr=?, memo=? WHERE ID='"+member.getId()+"'";
		Object[] param=new Object[] {
			member.getPass(), member.getName(), member.getAddr(), member.getMemo()	
		};
		template.update(sql,param);
		template.update("COMMIT");
	}

	@Override
	public void dao_delete(String id) {
		String sql="DELETE FROM SPRINGMEMBER WHERE ID='"+id+"'";
		template.update(sql);
		template.update("COMMIT");
	}

}
