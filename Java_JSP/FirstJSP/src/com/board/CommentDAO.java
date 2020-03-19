package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();

	public static CommentDAO getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public void commentInsert(CommentVO cvo) {
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=getConnection();
			// cnum,userid,regdate,msg,bnum
			String sql="INSERT INTO COMMENTBOARD VALUES (COMMENTBOARD_SEQ.NEXTVAL,?,SYSDATE,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, cvo.getUserid());
			ps.setString(2, cvo.getMsg());
			ps.setInt(3, cvo.getBnum());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(con,ps);
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
