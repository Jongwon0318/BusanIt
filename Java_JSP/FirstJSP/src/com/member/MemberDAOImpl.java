package com.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAOImpl implements MemberDAO {
	
	private static MemberDAOImpl instance=new MemberDAOImpl();
	
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx =(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	@Override
	public void memberInsert(MemberVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			String sql="INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getUserid());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getPhone());
			ps.setInt(6, vo.getAdmin());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
	}

	@Override
	public ArrayList<MemberVO> memberLIst() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<MemberVO> arr=new ArrayList<MemberVO>();
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				MemberVO vo=new MemberVO();
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
				arr.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		int flag=0;
		try {
			con=getConnection();
			String sql="UPDATE MEMBER"
					+ " SET name=?,"
					+ " pwd=?,"
					+ " email=?,"
					+ " phone=?,"
					+ " admin=?"
					+ " WHERE USERID=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getPhone());
			ps.setInt(5, vo.getAdmin());
			ps.setString(6, vo.getUserid());
			flag=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}	
		return flag;
	}

	@Override
	public MemberVO memberView(String userid) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		MemberVO vo=new MemberVO();
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER WHERE USERID = '"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setUserid(userid);
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}		
		return vo;
	}

	@Override
	public void memberDel(String userid) {
		Connection con=null;
		Statement st=null;
		try {
			con=getConnection();
			String sql="DELETE FROM MEMBER WHERE USERID='"+userid+"'";
			st=con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st);
		}
	}

	@Override
	public String idCheck(String userid) {
		String flag="yes";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER WHERE USERID = '"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				flag="no";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return flag;
	}
	
	//회원체크메소드
	public int loginCheck(String userid, String pwd) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int flag=-1; // -1 회원아님 0:관리자 1:일반회원 2:비번틀림
		try {
			con=getConnection();
			String sql="SELECT PWD,ADMIN FROM MEMBER WHERE USERID='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				if(pwd.equals(rs.getString("pwd"))) {
					flag=rs.getInt("admin");
				}else {
					flag=2; //비번오류
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}		
		return flag;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection(Connection con, Statement st) {
		try {
			if(con!=null) con.close();
			if(st!=null) st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
