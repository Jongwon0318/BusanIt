package review_ex;

import java.util.HashMap;
import java.util.Scanner;

//1.해쉬맵 map을 생성
//2.단어를 입력받아 단어와 입력 횟수를 저장
//3.대소문자구분없이 x치면 종료.
//4.map 출력
public class HashMapTest03 {
	public static void main(String[] args) {
		HashMap<String, Integer>hm=new HashMap();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("단어를 입력하세요. x를 입력하면 종료됩니다.");
			String word=sc.next();
			if(word.toLowerCase().equals("x")) break;
			hm.put(word, hm.containsValue(hm.get(word))? hm.get(word)+1 : 1);
		}
		System.out.println(hm);
	}
}
