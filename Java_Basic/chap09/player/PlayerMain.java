package chap09.player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlayerMain {
	Scanner sc = new Scanner(System.in);
	Connection con;

	public PlayerMain() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "HR";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void dbUse() {
		while (true) {
			System.out.println("1.선수등록 2.선수보기 3.선수찾기 4.선수삭제 5.선수정보수정 6.종료");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				playerInsert();
				break;
			case 2:
				playerView();
				break;
			case 3:
				playerSearch();
				break;
			case 4:
				playerDelete();
				break;
			case 5:
				playerUpdate();
				break;
			case 6:
				playerExit();
				break;
			default:
				System.out.println("입력오류");
			}
		}
	}

	private void playerInsert() {
		// 선수등록
		System.out.println("이름>>");
		String name = sc.nextLine();
		System.out.println("생일>>");
		String birth = sc.nextLine();
		System.out.println("키>>");
		double height = sc.nextDouble();
		System.out.println("몸무게>>");
		double weight = sc.nextDouble(); // 몸무게 +Enter
		sc.nextLine(); // Enter 처리
		System.out.println("종목>>");
		String kind = sc.nextLine();
		String sql = "INSERT INTO Player VALUES(Player_seq.NEXTVAL,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql); // 물음표를 감지한다.
			ps.setString(1, name);
			ps.setString(2, birth);
			ps.setDouble(3, height);
			ps.setDouble(4, weight);
			ps.setString(5, kind);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void playerView() {
		// 선수보기
		String sql = "SELECT * FROM Player ORDER BY num";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("생일 : " + rs.getString("birth"));
				System.out.println("키 : " + rs.getDouble("height"));
				System.out.println("몸무게 : " + rs.getDouble("weight"));
				System.out.println("종목 : " + rs.getString("kind"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void playerSearch() {
		// 선수 찾기
		System.out.println("찾을선수 이름>>");
		String sname = sc.nextLine();
		search(sname);
	}

	private void search(String sname) {
		String sql = "SELECT * FROM Player WHERE name LIKE '%" + sname + "%'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("번호 : " + rs.getInt("num"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("생일 : " + rs.getString("birth"));
				System.out.println("키 : " + rs.getDouble("height"));
				System.out.println("몸무게 : " + rs.getDouble("weight"));
				System.out.println("종목 : " + rs.getString("kind"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	private void playerDelete() {
		// 1.삭제할 이름 묻기, 2.이름 포함된 내용 보여주기, 3.번호를 입력받기, 4.그 번호에 해당하는 선수 삭제.
		System.out.println("삭제할 선수의 이름을 입력하세요.");
		String delname = sc.nextLine();
		search(delname); // 기본키로 지우기 위해 물어봄
		System.out.println("삭제할 선수의 번호를 입력하세요.");
		int delnum = sc.nextInt();
		String sql = "DELETE FROM Player WHERE num=" + delnum;
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("삭제완료");
		} catch (SQLException e) {
			System.out.println("오류발생!! 삭제불가");
		}
	}

	private void playerUpdate() {
		// 선수 수정
		// 1.선수의 이름 묻기, 2.이름 포함된 내용 보여주기, 3.번호 입력받기, 무엇을 수정할것인지 입력받기(1.이름~5.종목 6.종료),
		// 4.수정할 내용을 수정
		System.out.print("수정할 선수의 이름을 입력하세요.");
		String updateName = sc.nextLine();
		search(updateName);
		System.out.print("수정할 선수의 번호를 입력하세요.");
		int updateNum = sc.nextInt();
		System.out.println("수정컬럼 1.이름 2.생일 5.종목");
		int changeNum = sc.nextInt();
		sc.nextLine();
		System.out.print("수정할 내용을 입력하세요.");
		String content = sc.nextLine(); // 수정내용
//		UPDATE Player SET ??? = '???'  WHERE num=?
		String colName = "";
		switch (changeNum) {
		case 1:colName = "name";	break;
		case 2:colName = "birth";		break;
		case 5:colName = "kind";		break;
		}
		String sql = "UPDATE Player"+" SET " + colName + " = '" + content + "' WHERE num= " + updateNum;
		try {
			System.out.println(sql);
			Statement st = con.createStatement();
			int a=st.executeUpdate(sql); //Insert, Delete, Update
			
			System.out.println(a);
		} catch (SQLException e) {
			System.out.println("오류");
		}
	}

	private void playerExit() {
		// 종료
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
	}

	public static void main(String[] args) {
		PlayerMain pm = new PlayerMain();
		pm.dbUse();
	}

}
