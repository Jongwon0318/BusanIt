package org.address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SAddressDAO {
	private static SAddressDAO instance;

	public static SAddressDAO getInstance() {
		if (instance == null) {
			instance = new SAddressDAO();
		}
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}

	// 목록
	public ArrayList<AddressDTO> addressList() {
		ArrayList<AddressDTO> arr = new ArrayList<AddressDTO>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM ADDRESS ORDER BY NUM";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				AddressDTO adto = new AddressDTO();
				adto.setNum(rs.getInt("num"));
				adto.setName(rs.getString("name"));
				adto.setZipcode(rs.getString("zipcode"));
				adto.setAddr(rs.getString("addr"));
				adto.setTel(rs.getString("tel"));
				arr.add(adto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}

	// 추가
	public void addrInsert(AddressDTO adto) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "INSERT INTO ADDRESS VALUES (ADDRESS_SEQ.NEXTVAL,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, adto.getName());
			ps.setString(2, adto.getAddr());
			ps.setString(3, adto.getZipcode());
			ps.setString(4, adto.getTel());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}

	// 상세보기
	public AddressDTO addrView(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		AddressDTO adto = new AddressDTO();
		try {
			con = getConnection();
			String sql = "SELECT * FROM ADDRESS WHERE NUM=" + num;
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				adto.setNum(num);
				adto.setName(rs.getString("name"));
				adto.setZipcode(rs.getString("zipcode"));
				adto.setAddr(rs.getString("addr"));
				adto.setTel(rs.getString("tel"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return adto;
	}

	// 우편번호리스트
	public ArrayList<ZipcodeDTO> zipSearch(String dong) {
		ArrayList<ZipcodeDTO> arr = new ArrayList<ZipcodeDTO>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM ZIPCODE WHERE DONG LIKE '%" + dong + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ZipcodeDTO zdto = new ZipcodeDTO();
				zdto.setZipcode(rs.getString("zipcode"));
				zdto.setBunji(rs.getString("bunji"));
				zdto.setSido(rs.getString("sido"));
				zdto.setGugun(rs.getString("gugun"));
				zdto.setDong(rs.getString("dong"));
				arr.add(zdto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}

	// 찾기
	public ArrayList<AddressDTO> searchAddr(String option, String addr) {
		ArrayList<AddressDTO> arr = new ArrayList<AddressDTO>();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "SELECT * FROM ADDRESS WHERE " + option + " LIKE '%" + addr + "%' ORDER BY NUM";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				AddressDTO adto = new AddressDTO();
				adto.setNum(rs.getInt("num"));
				adto.setName(rs.getString("name"));
				adto.setAddr(rs.getString("addr"));
				adto.setTel(rs.getString("tel"));
				adto.setZipcode(rs.getString("zipcode"));
				arr.add(adto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return arr;
	}

	// 수정하기
	public void updateAddr(AddressDTO adto) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "UPDATE ADDRESS SET TEL=?, NAME=?, ADDR=?, ZIPCODE=? WHERE NUM=" + adto.getNum();
			ps = con.prepareStatement(sql);
			ps.setString(1, adto.getTel());
			ps.setString(2, adto.getName());
			ps.setString(3, adto.getAddr());
			ps.setString(4, adto.getZipcode());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}
	
	//삭제하기
	public void deleteAddr(int num) {
		Connection con=null;
		Statement st=null;
		try {
			con=getConnection();
			String sql="DELETE FROM ADDRESS WHERE NUM="+num;
			st=con.createStatement();
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st);
		}
	}
	
	private void closeConnection(Connection con, Statement st) {
		try {
			if (con != null)
				con.close();
			if (st != null)
				st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
			if (con != null)
				con.close();
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
			if (con != null)
				con.close();
			if (st != null)
				st.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
