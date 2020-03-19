package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Mon10 {
	HashMap<String, String> map = new HashMap<>();

	// phone.txt를 읽어다 map에 추가
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
			System.out.println("파일이 없습니다.");
		}
	}

	// 이름을 입력하면 전화번호를 출력
	private void search() {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름으로 전화번호를 찾습니다. x를 누르면 종료.");
		while (true) {
			System.out.print("찾을이름 >> ");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if (map.containsKey(name) == true) {
				System.out.println(map.get(name));
			} else {
				System.out.println("찾는 사람 없음.");
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
