package com.guestbook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GuestDAO {
	private static GuestDAO instance =new GuestDAO() ;
	
	public static GuestDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx =(Context)initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource)envCtx.lookup("jdbc/guest");
		return ds.getConnection();
	}
	
	//추가
	public void guestInsert(GuestDTO gdto) {
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=getConnection();
			String sql="INSERT INTO GUESTBOOK VALUES (GUESTBOOK_SEQ.NEXTVAL,?,?,?,SYSDATE,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, gdto.getName());
			ps.setString(2, gdto.getContent());
			ps.setString(3, gdto.getGrade());
			ps.setString(4, gdto.getIpaddr());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
	}
	//리스트
	public ArrayList<GuestDTO> guestList(){
		ArrayList<GuestDTO> arr=new ArrayList<GuestDTO>();
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT * FROM GUESTBOOK ORDER BY NUM";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				GuestDTO gdto=new GuestDTO();
				gdto.setContent(rs.getString("content"));
				gdto.setCreated(rs.getString("created"));
				gdto.setGrade(rs.getString("grade"));
				gdto.setIpaddr(rs.getString("ipaddr"));
				gdto.setName(rs.getString("name"));
				gdto.setNum(rs.getInt("num"));
				arr.add(gdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}
	//게시물 수
	public int guestCount() {
		int count=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT COUNT(*) FROM GUESTBOOK";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return count;
	}
	//상세보기
	public GuestDTO guestView(int num) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		GuestDTO gdto=new GuestDTO();
		try {
			con=getConnection();
			String sql="SELECT * FROM GUESTBOOK WHERE NUM="+num;
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				gdto.setContent(rs.getString("content"));
				gdto.setCreated(rs.getString("created"));
				gdto.setGrade(rs.getString("grade"));
				gdto.setIpaddr(rs.getString("ipaddr"));
				gdto.setName(rs.getString("name"));
				gdto.setNum(num);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return gdto;
	}
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if(con!=null) con.close();
			if(st!=null) st.close();
			if(rs!=null) rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
