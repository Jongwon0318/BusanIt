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

	public AppTest() {// myApp.txt 불러오기
		map.clear();
		try {// 파일이 없으면 만든다.
			File f = new File("src\\book_chap08\\myApp.txt");
			if (!f.exists()) {
				f.createNewFile();
				return;
			}
			// 파일을 읽어서 map에 추가.
			sc = new Scanner(new File("src\\book_chap08\\myApp.txt"));
			while (sc.hasNext()) {
				//String str = sc.nextLine();
				//String[] arr = str.split(" ");
				//map.put(arr[0], arr[1]);
				map.put(sc.next(), sc.next());
			}
		} catch (IOException e) {
			System.out.println("파일 오류");
		}
	}

	public static void showMenu() {
		System.out.println("****수도 맞추기 게임을 시작합니다****");
		System.out.print("입력:1,  퀴즈:2,  저장:3, 종료:4 >>");
	}

	public void input() {
		int cnt = 0;
		System.out.println("현재 입력된 나라와 수도는 " + cnt);
		System.out.println("국가와 수도를 입력합니다. 종료하시려면 x 입력");
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("국가와 수도를 입력하세요. ex)한국 서울");
			String str = sc.next();
			if (str.toLowerCase().equals("x"))
				break;
			String[] arr = str.split(" ");
			if (map.containsKey(str)) {
				System.out.println("해당 국가는 이미 존재합니다.");
				continue;
			}
			String str1=sc.next();
			map.put(str, str1);
			cnt++;
		}
	}

	public void quiz() {
		System.out.println("퀴즈 시작, x를 입력하면 종료");
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		while (true) {
			int r = (int) (Math.random() * map.size());
			System.out.println((String)arr[r] + "의 수도는 ?");
			String str = sc.next();
			if (str.toLowerCase().equals("x")) {
				System.out.println("종료");
				break;
			}
			if (str.equals(map.get((String) arr[r]))) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("오답입니다.");
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
				String key = it.next(); // 나라
				fw.write(key + " ");
				fw.write(map.get(key) + "\n"); // 수도
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
				System.out.println("종료");
				System.exit(0);
			default:
				System.out.println("입력오류");
			}
		}
	}

}
