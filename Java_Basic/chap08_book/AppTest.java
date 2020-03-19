package chap08_book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AppTest {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);

	public AppTest() {// myApp.txt �ҷ�����
		map.clear();
		try {// ������ ������ �����.
			File f = new File("src\\book_chap08\\myApp.txt");
			if (!f.exists()) {
				f.createNewFile();
				return;
			}
			// ������ �о map�� �߰�.
			sc = new Scanner(new File("src\\book_chap08\\myApp.txt"));
			while (sc.hasNext()) {
				//String str = sc.nextLine();
				//String[] arr = str.split(" ");
				//map.put(arr[0], arr[1]);
				map.put(sc.next(), sc.next());
			}
		} catch (IOException e) {
			System.out.println("���� ����");
		}
	}

	public static void showMenu() {
		System.out.println("****���� ���߱� ������ �����մϴ�****");
		System.out.print("�Է�:1,  ����:2,  ����:3, ����:4 >>");
	}

	public void input() {
		int cnt = 0;
		System.out.println("���� �Էµ� ����� ������ " + cnt);
		System.out.println("������ ������ �Է��մϴ�. �����Ͻ÷��� x �Է�");
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("������ ������ �Է��ϼ���. ex)�ѱ� ����");
			String str = sc.next();
			if (str.toLowerCase().equals("x"))
				break;
			String[] arr = str.split(" ");
			if (map.containsKey(str)) {
				System.out.println("�ش� ������ �̹� �����մϴ�.");
				continue;
			}
			String str1=sc.next();
			map.put(str, str1);
			cnt++;
		}
	}

	public void quiz() {
		System.out.println("���� ����, x�� �Է��ϸ� ����");
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		while (true) {
			int r = (int) (Math.random() * map.size());
			System.out.println((String)arr[r] + "�� ������ ?");
			String str = sc.next();
			if (str.toLowerCase().equals("x")) {
				System.out.println("����");
				break;
			}
			if (str.equals(map.get((String) arr[r]))) {
				System.out.println("�����Դϴ�.");
			}else {
				System.out.println("�����Դϴ�.");
			}
		}
	}

	public void save() {
		// myApp.txt
		try {
			FileWriter fw = new FileWriter(new File("src\\book_chap08\\myApp.txt"));
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next(); // ����
				fw.write(key + " ");
				fw.write(map.get(key) + "\n"); // ����
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		AppTest test = new AppTest();
		while (true) {
			AppTest.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				test.input();
				break;
			case 2:
				test.quiz();
				break;
			case 3:
				test.save();
				break;
			case 4:
				System.out.println("����");
				System.exit(0);
			default:
				System.out.println("�Է¿���");
			}
		}
	}

}
