package review_ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AppTest {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = null;

	public AppTest() {
		try {
			File f=new File("src\\review_ex2\\appended.txt");
			sc = new Scanner(f);
			if(!f.exists()) {
				f.createNewFile();
				return;
			}
			while (sc.hasNext()) {
				map.put(sc.next(), sc.next());
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showMenu() {
		sc = new Scanner(System.in);
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println("1 : �Է�, 2 : ����, 3 : ���� �� ����");
	}

	public void input() {
		System.out.println("������� �Էµ� ���� �� : " + map.size());
		System.out.println("�Է��� �����մϴ�. x�� �Է��ϸ� ����");
		while (true) {
			System.out.println("������ �Է��ϼ���.");
			String str = sc.next();
			if (str.toLowerCase().equals("x")) {
				System.out.println("�Է��� �����մϴ�.");
				break;
			} else if (map.containsKey(str)) {
				System.out.println("�̹� �����ϴ� �����Դϴ�.");
				continue;
			}
			System.out.println("������ �Է��ϼ���.");
			String str1 = sc.next();
			map.put(str, str1);
		}

	}

	public void quiz() {
		System.out.println("��� �����մϴ�. x�� �Է��ϸ� ����");
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		while (true) {
			int r = (int) (Math.random() * map.size());
			System.out.println((String) arr[r] + "�� ������ ?");
			String answer = sc.next();
			if (answer.toLowerCase().equals("x")) {
				System.out.println("��� �����մϴ�.");
				break;
			}
			if (answer.equals(map.get(arr[r]))) {
				System.out.println("�����Դϴ�.");
			} else {
				System.out.println("�����Դϴ�.");
			}
		}
	}

	public void save() {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new File("src\\review_ex\\appended.txt"));
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();
				ps.println(key + " " + map.get(key));
			}
		} catch (IOException e) {
			System.out.println("����� ����");
		} finally {
			sc.close();
			ps.close();
		}
	}

	public static void main(String[] args) {
		AppTest test = new AppTest();
		while (true) {
			test.showMenu();
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("���ù�ȣ �Է¿���");
			}
		}
	}
}