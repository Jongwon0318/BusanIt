package org.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SMemberDAOImpl implements SMemberDAO{
	private static SMemberDAOImpl instance=new SMemberDAOImpl();
	
	public static SMemberDAOImpl getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	//추가
	@Override
	public void memInsert(MemberDTO mdto) {
		Connection con=null;
		PreparedStatement ps=null;

		try {
			con=getConnection();
			String sql="INSERT INTO MEMBER VALUES (?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getUserid());
			ps.setString(3, mdto.getPwd());
			ps.setString(4, mdto.getEmail());
			ps.setString(5, mdto.getPhone());
			ps.setInt(6, mdto.getAdmin());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,ps);
		}
	}

	//전체보기
	@Override
	public ArrayList<MemberDTO> memList() {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ArrayList<MemberDTO> arr=new ArrayList<MemberDTO>();
		
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				MemberDTO mdto=new MemberDTO();
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setAdmin(rs.getInt("admin"));
				mdto.setEmail(rs.getString("email"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setUserid(rs.getString("userid"));
				arr.add(mdto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,st,rs);
		}
		return arr;
	}

	//수정
	@Override
	public void memUpdate(MemberDTO mdto) {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=getConnection();
			String sql="UPDATE MEMBER"
					+ " SET name = ?,pwd = ?,email = ?, phone = ?, admin = ?"
					+ " WHERE USERID='"+mdto.getUserid()+"'";
			ps=con.prepareStatement(sql);
			ps.setString(1, mdto.getName());
			ps.setString(2, mdto.getPwd());
			ps.setString(3, mdto.getEmail());
			ps.setString(4, mdto.getPhone());
			ps.setInt(5, mdto.getAdmin());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps);
		}
	}

	//삭제
	@Override
	public void memDelete(String userid) {
		Connection con=null;
		Statement st=null;
		try {
			con=getConnection();
			String sql="DELETE FROM MEMBER WHERE USERID='"+userid+"'";
			System.out.println(sql);
			st=con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st);
		}
	}

	//상세보기
	@Override
	public MemberDTO memView(String userid) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		MemberDTO mdto=new MemberDTO();
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER WHERE USERID='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				mdto.setAdmin(rs.getInt("admin"));
				mdto.setEmail(rs.getString("email"));
				mdto.setName(rs.getString("name"));
				mdto.setPhone(rs.getString("phone"));
				mdto.setPwd(rs.getString("pwd"));
				mdto.setUserid(rs.getString("userid"));
			}
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return mdto;
	}
	//로그인체크
	public MemberDTO loginCheck(String userid, String pwd) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		MemberDTO mdto= null;
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER WHERE USERID= '"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) { //회원인데 비밀번호가 맞는지는 모름
				mdto=new MemberDTO();
				if(rs.getString("pwd").equals(pwd)) { //비밀번호맞음
					mdto.setAdmin(rs.getShort("admin")); //1,0
					mdto.setEmail(rs.getString("email"));
					mdto.setName(rs.getString("name"));
					mdto.setPhone(rs.getString("phone"));
					mdto.setPwd(pwd);
					mdto.setUserid(userid);
				}else { //비밀번호틀림
					mdto.setAdmin(2);
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, st, rs);
		}
		return mdto;
	}
	
	//아이디체크
	public int idCheck(String userid) {
		int check=0;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			con=getConnection();
			String sql="SELECT * FROM MEMBER WHERE USERID='"+userid+"'";
			st=con.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next()) {
				check=1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, st, rs);
		}
		return check;
	}
	
	private void closeConnection(Connection con, Statement st) {
		try {
		if(con!=null) con.close();
		if(st!=null) st.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void closeConnection(Connection con, PreparedStatement ps) {
		try {
		if(con!=null) con.close();
		if(ps!=null) ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void closeConnection(Connection con, Statement st, ResultSet rs) {
		try {
		if(con!=null) con.close();
		if(st!=null) st.close();
		if(rs!=null) rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
