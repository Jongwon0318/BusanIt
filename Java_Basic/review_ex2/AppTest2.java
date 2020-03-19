package review_ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class AppTest2 {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = null;
	

	public AppTest2() {
		try {
			File f=new File("src\\review_ex2\\Data.txt");
			sc = new Scanner(f);
			if(!f.exists()) {
					f.createNewFile();
					return;
			}
			while (sc.hasNext()) {
				map.put(sc.next(), sc.next());
			}
		}catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		}catch(IOException e){
			System.out.println("����� ���� �߻�");
		}
	}

	public void showMenu() {
		sc=new Scanner(System.in);
		System.out.println("���α׷��� �����մϴ�.");
		System.out.println("1:�Է�, 2:����, 3:���� �� ����");
		System.out.print("���� >>>> ");
	}

	public void input() {
		System.out.println("������� �Էµ� ���� �� : " + map.size());
		System.out.println("�Է��� �����մϴ�... �����Ͻ÷��� x �Է�");
		while (true) {
			System.out.print("���� �Է��ϼ��� >>> ");
			String str = sc.next();
			if (str.toLowerCase().equals("x")) {
				System.out.println("�Է��� �����մϴ�.");
				break;
			}else if(map.containsKey(str)) {
				System.out.println("�̹� �����ϴ� �����Դϴ�.");
				continue;
			}
			System.out.println();
			System.out.print("������ �Է��ϼ��� >>>");
			String str1 = sc.next();
			map.put(str, str1);
		}
	}

	public void quiz() {
		System.out.println("��� �����մϴ�... �����Ͻ÷��� x �Է�");
		Set<String> keys = map.keySet();
		Object[] arr = keys.toArray();
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
			ps=new PrintStream(new File("src\\review_ex2\\Data.txt"));
			Set<String> keys = map.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String str=it.next();
				ps.println(str+" "+map.get(str));
			}
		} catch (IOException e) {
			System.out.println("����� ����");
		}finally {
			sc.close();
			ps.close();
		}
	}

	public static void main(String[] args) {
		AppTest2 test = new AppTest2();
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