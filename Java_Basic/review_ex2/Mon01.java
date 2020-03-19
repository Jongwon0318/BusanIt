package review_ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Mon01 {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = null;
	PrintStream ps = null;
	
	public Mon01(){
		try {
			File f = new File("src\\review_ex2\\phone.txt");
			if (!f.exists()) {
				f.createNewFile();
				return;
			}
			sc=new Scanner(new File("src\\review_ex2\\phone.txt"));
			while(sc.hasNext()) {
				map.put(sc.next(), sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void input() {
		System.out.println("현재까지 입력된 전화번호 : "+map.size());
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("이름과 전화번호를 입력하세요. 종료는 x입력.");
			String str = sc.nextLine();
			if (str.toLowerCase().equals("x")) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			String[] arr = str.split(" ");
			map.put(arr[0], arr[1]);
		}

	}

	public void show() {
		Set<String> key = map.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()) {
			String str=it.next();
			System.out.println(str+"\t"+map.get(str));
		}
	}

	public void save() {
		try {
			ps = new PrintStream(new File("src\\review_ex2\\phone.txt"));
			Set<String> key = map.keySet();
			Iterator<String> it = key.iterator();
			while (it.hasNext()) {
				String str=it.next();
				ps.println(str + "\t" + map.get(str));
			}
		} catch (FileNotFoundException f) {
			System.out.println("파일이 없어요.");
		}finally {
			sc.close();
			ps.close();
		}

	}

	public static void main(String[] args) {
		Mon01 test = new Mon01();
		System.out.println("전화번호부 프로그램을 시작합니다. 종료하시려면 저장 혹은 x입력");
		while(true) {
			System.out.println("선택하세요 : 1.입력, 2:데이터 출력, 3:저장 및 종료");
			sc=new Scanner(System.in);
			String choice=sc.next();
			if(choice.toLowerCase().equals("x")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			switch(choice) {
			case "1" : test.input(); break;
			case "2" : test.show(); break;
			case "3" : test.save();
							System.out.println("프로그램을 종료합니다.");
							System.exit(0);
			default : System.out.println("선택 오류");
			}
		}
	}

}
