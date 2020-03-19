package com.jquery.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JAddressDAO {
	private static JAddressDAO instance=new JAddressDAO();
	
	public static JAddressDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initCtx=new InitialContext();
		Context envCtx=(Context) initCtx.lookup("java:comp/env");
		DataSource ds=(DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public void addressInsert(AddressVO vo) {
		Connection con=null;
		PreparedStatement ps=null;
		try {			
			con=getConnection();
			String sql="INSERT INTO ADDRESS VALUES (address_seq.nextval, ?, ?, ?, ?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getAddr());
			ps.setString(3, vo.getZipcode());
			ps.setString(4, vo.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	public ArrayList<ZipcodeVO> addressSearch(String dong) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<ZipcodeVO> arr=new ArrayList<ZipcodeVO>();
		try {
			con=getConnection();
			String sql="SELECT * FROM ZIPCODE WHERE DONG LIKE '%"+dong+"%' ORDER BY SEQ";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				ZipcodeVO vo=new ZipcodeVO();
				vo.setSeq(rs.getInt("SEQ"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setSido(rs.getString("SIDO"));
				vo.setGugun(rs.getString("GUGUN"));
				vo.setDong(rs.getString("DONG"));
				vo.setBunji(rs.getString("BUNJI"));
				arr.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
	}
	
	
	public ArrayList<AddressVO> getList(){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<AddressVO> arr=new ArrayList<AddressVO>();
		try {
			con=getConnection();
			String sql="SELECT * FROM ADDRESS ORDER BY NUM";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				AddressVO vo=new AddressVO();
				vo.setNum(rs.getInt("NUM"));
				vo.setName(rs.getString("NAME"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setAddr(rs.getString("ADDR"));
				vo.setTel(rs.getString("TEL"));
				arr.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
	}

	public ArrayList<AddressVO> getSearch(String field, String word){
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<AddressVO> arr=new ArrayList<AddressVO>();
		try {
			con=getConnection();
			String sql="SELECT * FROM ADDRESS "
								+"WHERE "+field+" LIKE '%"+word+"%' "
								+" ORDER BY NUM";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				AddressVO vo=new AddressVO();
				vo.setNum(rs.getInt("NUM"));
				vo.setName(rs.getString("NAME"));
				vo.setZipcode(rs.getString("ZIPCODE"));
				vo.setAddr(rs.getString("ADDR"));
				vo.setTel(rs.getString("TEL"));
				arr.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
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

	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if(con!=null) con.close();
			if(ps!=null) ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
