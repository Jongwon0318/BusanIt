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
			System.out.println("1.������� 2.�������� 3.����ã�� 4.�������� 5.������������ 6.����");
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
				System.out.println("�Է¿���");
			}
		}
	}

	private void playerInsert() {
		// �������
		System.out.println("�̸�>>");
		String name = sc.nextLine();
		System.out.println("����>>");
		String birth = sc.nextLine();
		System.out.println("Ű>>");
		double height = sc.nextDouble();
		System.out.println("������>>");
		double weight = sc.nextDouble(); // ������ +Enter
		sc.nextLine(); // Enter ó��
		System.out.println("����>>");
		String kind = sc.nextLine();
		String sql = "INSERT INTO Player VALUES(Player_seq.NEXTVAL,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql); // ����ǥ�� �����Ѵ�.
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
		// ��������
		String sql = "SELECT * FROM Player ORDER BY num";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("��ȣ : " + rs.getInt("num"));
				System.out.println("�̸� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getString("birth"));
				System.out.println("Ű : " + rs.getDouble("height"));
				System.out.println("������ : " + rs.getDouble("weight"));
				System.out.println("���� : " + rs.getString("kind"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void playerSearch() {
		// ���� ã��
		System.out.println("ã������ �̸�>>");
		String sname = sc.nextLine();
		search(sname);
	}

	private void search(String sname) {
		String sql = "SELECT * FROM Player WHERE name LIKE '%" + sname + "%'";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("��ȣ : " + rs.getInt("num"));
				System.out.println("�̸� : " + rs.getString("name"));
				System.out.println("���� : " + rs.getString("birth"));
				System.out.println("Ű : " + rs.getDouble("height"));
				System.out.println("������ : " + rs.getDouble("weight"));
				System.out.println("���� : " + rs.getString("kind"));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	private void playerDelete() {
		// 1.������ �̸� ����, 2.�̸� ���Ե� ���� �����ֱ�, 3.��ȣ�� �Է¹ޱ�, 4.�� ��ȣ�� �ش��ϴ� ���� ����.
		System.out.println("������ ������ �̸��� �Է��ϼ���.");
		String delname = sc.nextLine();
		search(delname); // �⺻Ű�� ����� ���� ���
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���.");
		int delnum = sc.nextInt();
		String sql = "DELETE FROM Player WHERE num=" + delnum;
		try {
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("�����Ϸ�");
		} catch (SQLException e) {
			System.out.println("�����߻�!! �����Ұ�");
		}
	}

	private void playerUpdate() {
		// ���� ����
		// 1.������ �̸� ����, 2.�̸� ���Ե� ���� �����ֱ�, 3.��ȣ �Է¹ޱ�, ������ �����Ұ����� �Է¹ޱ�(1.�̸�~5.���� 6.����),
		// 4.������ ������ ����
		System.out.print("������ ������ �̸��� �Է��ϼ���.");
		String updateName = sc.nextLine();
		search(updateName);
		System.out.print("������ ������ ��ȣ�� �Է��ϼ���.");
		int updateNum = sc.nextInt();
		System.out.println("�����÷� 1.�̸� 2.���� 5.����");
		int changeNum = sc.nextInt();
		sc.nextLine();
		System.out.print("������ ������ �Է��ϼ���.");
		String content = sc.nextLine(); // ��������
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
			System.out.println("����");
		}
	}

	private void playerExit() {
		// ����
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

	public static void main(String[] args) {
		PlayerMain pm = new PlayerMain();
		pm.dbUse();
	}

}
