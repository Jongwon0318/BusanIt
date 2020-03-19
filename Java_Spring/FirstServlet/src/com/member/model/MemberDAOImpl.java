package com.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO{
	
	private static MemberDAOImpl instance=new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	@Override
	public ArrayList<MemberDTO> getMemberList() {
		ArrayList<MemberDTO> list=new ArrayList<MemberDTO>();
		Connection con=null;
		Statement st=null;	
		ResultSet rs=null;
		try {
			String sql="SELECT * FROM SPRINGMEMBER";
			con=getConnection();
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				MemberDTO user=new MemberDTO();
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				user.setAddr(rs.getString("addr"));
				user.setMemo(rs.getString("memo"));
				user.setReg_date(rs.getString("reg_date"));
				user.setName(rs.getString("name"));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return list;
	}

	@Override
	public MemberDTO findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(MemberDTO user) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			String sql="INSERT INTO SPRINGMEMBER VALUES(?,?,?,?,?,SYSDATE)";
			con=getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAddr());
			ps.setString(5, user.getMemo());
			ps.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
	}

	@Override
	public void update(MemberDTO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void closeConnection(Connection con,Statement st, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
