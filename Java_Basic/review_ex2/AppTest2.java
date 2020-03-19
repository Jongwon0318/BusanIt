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
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(IOException e){
			System.out.println("입출력 오류 발생");
		}
	}

	public void showMenu() {
		sc=new Scanner(System.in);
		System.out.println("프로그램을 시작합니다.");
		System.out.println("1:입력, 2:퀴즈, 3:저장 및 종료");
		System.out.print("선택 >>>> ");
	}

	public void input() {
		System.out.println("현재까지 입력된 나라 수 : " + map.size());
		System.out.println("입력을 시작합니다... 종료하시려면 x 입력");
		while (true) {
			System.out.print("나라를 입력하세요 >>> ");
			String str = sc.next();
			if (str.toLowerCase().equals("x")) {
				System.out.println("입력을 종료합니다.");
				break;
			}else if(map.containsKey(str)) {
				System.out.println("이미 존재하는 국가입니다.");
				continue;
			}
			System.out.println();
			System.out.print("수도를 입력하세요 >>>");
			String str1 = sc.next();
			map.put(str, str1);
		}
	}

	public void quiz() {
		System.out.println("퀴즈를 시작합니다... 종료하시려면 x 입력");
		Set<String> keys = map.keySet();
		Object[] arr = keys.toArray();
		while (true) {
			int r = (int) (Math.random() * map.size());
			System.out.println((String) arr[r] + "의 수도는 ?");
			String answer = sc.next();
			if (answer.toLowerCase().equals("x")) {
				System.out.println("퀴즈를 종료합니다.");
				break;
			}
			if (answer.equals(map.get(arr[r]))) {
				System.out.println("정답입니다.");
			} else {
				System.out.println("오답입니다.");
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
			System.out.println("입출력 오류");
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("선택번호 입력오류");
			}
		}
	}
}