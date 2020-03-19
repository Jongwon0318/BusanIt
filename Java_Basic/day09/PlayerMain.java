package day09;

import java.util.Scanner;

public class PlayerMain {
	public static Scanner sc=new Scanner(System.in);
	public static void showMenu() {
		System.out.println("\n"+"선택하세요...");
		System.out.println("1. 선수 등록");
		System.out.println("2. 선수 보기");
		System.out.println("3. 선수 찾기");
		System.out.println("4. 종료");
		System.out.print("선택 : ");
 	}
	
	public static void main(String[] args) {
		PlayerManager pm=new PlayerManager();
		while(true) {
			PlayerMain.showMenu();
			int choice=PlayerMain.sc.nextInt();
			PlayerMain.sc.nextLine(); //choice를 입력할때(int choice+enter) 포함된 엔터를 처리하기위해 추가한 문장..!!
			switch(choice) {
			case 1 :	pm.insertPlayer(); break;
			case 2 :	pm.viewPlayer(); break;
			case 3 : pm.searchPlayer(); break;
			case 4 : System.out.println("프로그램을 종료합니다");
							System.exit(0);
			default :  System.out.println("입력오류");
			}
		}
	}
	
}