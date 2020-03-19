package chap07_book;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Nation {
	String country;
	String capital;

	public Nation(String country, String capital) {
		super();
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}

public class Mon11_02 {
	HashMap<String,String> map=new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	
	public void menu() {
		System.out.print("입력:1,  퀴즈:2,  종료:3 >>");
	}
	
	public void input() {
		System.out.println("현재 "+map.size()+"개 나라와 수도가 입력되어 있습니다.");
		System.out.print("나라와 수도 입력"+map.size()+" >>");
		String line=sc.nextLine();
		String[] arr=line.split(" ");
		Nation na=new Nation(arr[0],arr[1]);
		if(map.containsKey(arr[0])) System.out.println(arr[0]+": 이미 있습니다!!");
		else map.put(arr[0], arr[1]);
	}
	
	public void quiz() {
		Set<String> set=map.keySet();
		Object[] arr=(String[])set.toArray();
		while(true) {
			int r=(int)Math.random()*map.size();
			System.out.println(arr[r]+"의 수도는?");
			
		}
	}
	
	public static void main(String[] args) {
		Mon11_02 mon=new Mon11_02();
		System.out.println("****수도 맞추기 게임을 시작합니다. ****");
		while(true) {
			mon.menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1: mon.input();
			case 2: mon.quiz();
			case 3: System.out.println("프로그램을 종료합니다.");
							System.exit(0);
			default : System.out.println("선택번호 입력 오류");
			}
		}
				
	}

}
