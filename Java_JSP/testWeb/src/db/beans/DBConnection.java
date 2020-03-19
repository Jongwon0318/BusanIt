package db.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("DB연결시도");
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource) envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public static Connection getConnection(String ip,int port,String db,String user,String pw) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@"+ip+":"+port+":"+db, user, pw);
	}

}
