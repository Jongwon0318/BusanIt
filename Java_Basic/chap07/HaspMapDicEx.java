package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HaspMapDicEx {

	public static void main(String[] args) {
		HashMap<String,String> dic=new HashMap<String,String>();
		dic.put("baby","아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");
		//사용자로부터 영어단어를입력받고 한글단어거맥, exit입력받으면 종료
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("찾고 싶은 단어는? exit를 입력하면 종료. ");
			String eng=sc.next();
			if(eng.toLowerCase().equals("exit")) {
				System.out.println("종료합니다.");
				break;
			}
			String kor=dic.get(eng);
			if(kor==null) {
				System.out.println(eng+"는 없는 단어");
			}else {
				System.out.println(eng+"는 "+kor);
			}
		}
		sc.close();
	}

}
