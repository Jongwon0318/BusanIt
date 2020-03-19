package com.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();
	public static AddressDAO getInstance() {
		return  instance;
	}
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx =(Context)initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	//insert
	public void addrInsert(Address ad) {
		Connection con = null;
		PreparedStatement ps= null;
		try {
			con = getConnection();
		    String sql = "insert into address values(address_seq.nextval,?,?,?,?)";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, ad.getName());
		    ps.setString(2, ad.getAddr());
		    ps.setString(3, ad.getZipcode());
		    ps.setString(4, ad.getTel());
		    ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps);
		}
		
	}
	// list
	public ArrayList<Address> addrList(String field, String word) {
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		ArrayList<Address> arr = new ArrayList<Address>();
		String sql="";
		try {
			con = getConnection();
			if(word.equals("")) {
				sql="select * from address";
			}else {
				sql="select * from address where "+field+" like '%"+word+"%'";
			}
			st = con.createStatement();
			rs  = st.executeQuery(sql);
			while(rs.next()) {
				Address ad = new Address();
				ad.setNum(rs.getInt("num"));
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
				arr.add(ad);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
		
	}
  //	주소록 갯수
	public int getCount(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		String sql="";
		try {
			con = getConnection();
			if(word.equals("")) {
				sql = "select count(*) from address";	
			}else {
				sql = "select count(*) from address where "+field+" like '%"+word+"%'";
			}			
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeConnection(con, st, rs);
		}
		return count;
		
	}
	//detail
	public Address addrDetail(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Address ad = null;
		
		try {
			con= getConnection();
			String sql = "select * from address where num="+num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				ad= new Address();
				ad.setNum(rs.getInt("num"));
				ad.setAddr(rs.getString("addr"));
				ad.setName(rs.getString("name"));
				ad.setTel(rs.getString("tel"));
				ad.setZipcode(rs.getString("zipcode"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return ad;
		
	}
	//update
	public void addrUpdate(Address ad) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con =getConnection();
			String sql = "update Address "
					+ " set name=?, zipcode =?, tel =?, addr=? where num=?"; 
		   ps = con.prepareStatement(sql);
		   ps.setString(1, ad.getName());
		   ps.setString(2, ad.getZipcode());
		   ps.setString(3, ad.getTel());
		   ps.setString(4, ad.getAddr());
		   ps.setInt(5, ad.getNum());
		   ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, ps);
		}
	}
	//delete
	public void addrDelete(int num) {
		Connection con = null;
		Statement st = null;
			
		try {
			con =getConnection();
			String sql = "delete from address where num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con, st);
		}
		
	}
	//우편번호검색
	public ArrayList<ZipCodeBean> zipfinder(String dong) {
		Connection con =null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<ZipCodeBean> zarr=new ArrayList<ZipCodeBean>();
		try {
			con=getConnection();
			String sql="select * from zipcode where dong like '%"+dong+"%'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				ZipCodeBean zcb=new ZipCodeBean();
				zcb.setZipcode(rs.getString("zipcode"));
				zcb.setSido(rs.getString("sido"));
				zcb.setGugun(rs.getString("gugun"));
				zcb.setDong(rs.getString("dong"));
				zcb.setBunji(rs.getString("bunji"));
				zcb.setSeq(rs.getInt("seq"));
				zarr.add(zcb);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return zarr;
	}
	// 종료메소드
	private void closeConnection(Connection con, Statement st) {
			try {
				if(st!=null)  		st.close();
				if(con!=null)  		con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	private void closeConnection(Connection con, 
			PreparedStatement ps) {
			try {
				if(ps!=null)  		ps.close();
				if(con!=null)  		con.close();
			} catch (SQLException e) {
							e.printStackTrace();
			}
	}
	private void closeConnection(Connection con, 
			Statement st, ResultSet rs) {
			try {
				if(rs!=null)  		rs.close();
				if(st!=null)  		st.close();
				if(con!=null)  		con.close();
			} catch (SQLException e) {
							e.printStackTrace();
			}
	}
}

