package chap04_book;
import java.util.Scanner;

import day08.Teacher;

public class Test03 {
	Song[] arr=new Song[3];
	int cnt;
	public void input() {
		System.out.println("노래 3곡의 정보를 입력하세요.");
		while(true) {
			System.out.println("발매년도를 입력하세요.");
			int year=Teacher.sc.nextInt();
			System.out.println("아티스트를 입력하세요.");
			String artist=Teacher.sc.next();
			System.out.println("국적을 입력하세요.");
			String country=Teacher.sc.next();
			System.out.println("제목을 입력하세요.");
			String title=Teacher.sc.next();
			arr[cnt++]=new Song(title,artist,country,year);
			if (cnt==3) break;
		}
	}
	
	public void view() {
		for(int i=0; i<arr.length; i++) arr[i].show();
	}
	
	public static void main(String[] args) {
		Test03 test=new Test03();
		test.input(); //입력
		test.view(); //출력
	}
}
