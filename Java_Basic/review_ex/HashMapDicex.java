package review_ex;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicex {

	public static void main(String[] args) {
		HashMap<String,String> dic=new HashMap<String,String>();
		dic.put("baby","아기");
		dic.put("love", "사랑");
		dic.put("apple", "사과");

		//사용자로부터 영어단어를입력받고 한글단어거맥, exit입력받으면 종료
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("영단어를 입력하세요. exit를 입력하면 종료됩니다.");
			String word=sc.next();
			if(word.toLowerCase().equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(dic.containsKey(word)==false) {
				System.out.println("입력하신 단어가 없습니다.");
			}else {
				System.out.println(dic.get(word));
			}
		}
	}

}
