package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemberRowMapper implements RowMapper<MemberDTO> {

	@Override
	public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDTO user=new MemberDTO();
		user.setId(rs.getString("ID"));
		user.setName(rs.getString("name"));
		user.setAddr(rs.getString("addr"));
		user.setPass(rs.getString("pass"));
		user.setReg_date(rs.getString("reg_date"));
		user.setMemo(rs.getString("memo"));
		return user;
	}
	
}
