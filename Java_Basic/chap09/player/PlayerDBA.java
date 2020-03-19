package chap09.player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDBA {
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet res;
	String url, user, password;

	public PlayerDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "HR";
			password = "1234";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 추가(이름,생일,키,몸무게,종목)
	public void playerInsert(Player p) {
		try {
			con = null;
			ps = null;

			String sql = "INSERT INTO Player VALUES(player_seq.NEXTVAL, ?,?,?,?,?)";
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getBirth());
			ps.setDouble(3, p.getHeight());
			ps.setDouble(4, p.getWeight());
			ps.setString(5, p.getKind());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 수정
	public void playerUpdate(Player p) {
		con = null;
		st = null;
		ps = null;
		try {
			String sql = "UPDATE Player SET name=?, birth=?, height=?, weight=?, kind=? WHERE num=" + p.getNum();
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getBirth());
			ps.setDouble(3, p.getHeight());
			ps.setDouble(4, p.getWeight());
			ps.setString(5, p.getKind());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (st != null)
					st.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 삭제
	public void playerDelete(int num) {
		con = null;
		st = null;
		try {
			String sql = "DELETE FROM Player WHERE num=" + num;
			con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (st != null)
					st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 전체보기
	public ArrayList<Player> playerView() {
		con = null;
		st = null;
		res = null;
		ArrayList<Player> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Player ORDER BY num";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			res = st.executeQuery(sql);

			while (res.next()) {
				Player p = new Player();
				p.setNum(res.getInt("num"));
				p.setName(res.getString("name"));
				p.setBirth(res.getString("birth"));
				p.setHeight(res.getDouble("height"));
				p.setWeight(res.getDouble("weight"));
				p.setKind(res.getString("kind"));
				arr.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	// 검색
	public ArrayList<Player> playerSearch(String colName, String word) {
		con = null;
		st = null;
		res = null;
		ArrayList<Player> arr = new ArrayList<>();
		try {
			String sql = "SELECT * FROM Player WHERE " + colName + " LIKE '%" + word + "%'";
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			res = st.executeQuery(sql);

			while (res.next()) {
				Player p = new Player();
				p.setNum(res.getInt("num"));
				p.setName(res.getString("name"));
				p.setBirth(res.getString("birth"));
				p.setHeight(res.getDouble("height"));
				p.setWeight(res.getDouble("weight"));
				p.setKind(res.getString("kind"));
				arr.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arr;
	}

	// 상세보기
	public Player playerDetail(int num) {
		con = null;
		st = null;
		res = null;
		Player p1 = new Player();
		try {
			String sql = "SELECT * FROM Player WHERE num=" + num;
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			res = st.executeQuery(sql);
			if (res.next()) {
				p1.setNum(res.getInt("num"));
				p1.setName(res.getString("name"));
				p1.setBirth(res.getString("birth"));
				p1.setHeight(res.getDouble("height"));
				p1.setWeight(res.getDouble("weight"));
				p1.setKind(res.getString("kind"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (res != null)
					res.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p1;
	}

}
