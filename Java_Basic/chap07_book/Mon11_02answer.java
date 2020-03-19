package chap07_book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Mon11_02answer {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public Mon11_02answer() {
		map.put("한국","서울");
		map.put("일본","동경");
		map.put("중국","베이징");
		map.put("독일","베를린");
	}
	public static void showMenu() {
		System.out.println("****수도 맞추기 게임을 시작합니다****");
		System.out.print("입력:1,  퀴즈:2,  종료:3 >>");
	}

	public void input() {
		System.out.println("현재"+map.size()+"개 나라와 수도 등록");
		while(true) {
			System.out.print("나라와 수도 입력..종료는 x>>");
			String str=sc.next(); //나라
			if(str.toLowerCase().equals("x")) break;
			if(map.containsKey(str)) {
				System.out.println("이미 등록된 나라");
				continue;
			}
			String str1=sc.next();//수도
			map.put(str, str1);
		}
	}

	public void quiz() {
		Set<String> set=map.keySet();
		Object[] arr=set.toArray();
//		Iterator<String> it=set.iterator();
//		int i=0;
//		String[] arr=new String[set.size()];
//		while(it.hasNext()) {
//			arr[i]=it.next();
//			i++;
//		}
		while(true) {
			int r=(int)(Math.random()*set.size());
			String mon=(String)arr[r]; //문제
			String dap=map.get(arr[r]); //답
			
			//퀴즈출제
			System.out.println(mon+"의 수도는? 종료는 x");
			String city=sc.next();
			if(city.toLowerCase().equals("x")) break;
			if(city.equals(dap)) {
				System.out.println("정답입니다.");
			}else {
				System.out.println("틀렸습니다.");
			}
		}
		
	}

	public static void main(String[] args) {
		Mon11_02answer test = new Mon11_02answer();
		while (true) {
			Mon11_02answer.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				test.input();
			case 2:
				test.quiz();
			case 3:
				System.out.println("종료");
				System.exit(0);
			default:
				System.out.println("입력오류");
			}
		}
	}

}
