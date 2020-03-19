package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Mon10 {
	HashMap<String, String> map = new HashMap<>();

	// phone.txt�� �о�� map�� �߰�
	private void load() {
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src\\book_chap08\\phone.txt"));
			while (sc.hasNextLine()) {
				String str = sc.nextLine();
				String[] arr = str.split(" ");
				map.put(arr[0], arr[1]);
				sc.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		}
	}

	// �̸��� �Է��ϸ� ��ȭ��ȣ�� ���
	private void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�̸����� ��ȭ��ȣ�� ã���ϴ�. x�� ������ ����.");
		while (true) {
			System.out.print("ã���̸� >> ");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			if (map.containsKey(name) == true) {
				System.out.println(map.get(name));
			} else {
				System.out.println("ã�� ��� ����.");
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		Mon10 test = new Mon10();
		test.load();
		test.search();
	}
}
