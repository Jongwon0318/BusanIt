package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03 {

	public static void main(String[] args) {
		//1.해쉬맵 map을 생성
		//2.단어를 입력받아 단어와 입력 횟수를 저장
		//3.대소문자구분없이 x치면 종료.
		//4.map 출력
//		HashMap<String,Integer> map=new HashMap<String, Integer>();
//		Scanner sc=new Scanner(System.in);
//		while(true) {
//			System.out.println("단어를 입력하세요... X를 입력하면 종료됩니다.");
//			String word=sc.next();
//			
//			if(word.equals("X")) {
//				System.out.println(map);
//				break;
//			}
//			
//			if(map.containsKey(word)==false) {
//				Integer num=1;
//				map.put(word,num);
//			}else {
//				map.get(word)+1;
//			}
//		}
		HashMap<String,Integer> map=new HashMap();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("단어 입력, 종료는 x");
			String word=sc.next();
//			int value=1;
			if(word.toLowerCase().equals("x")) break;
			map.put(word, (map.containsKey(word))==true? map.get(word)+1: 1);
		}
//			
//			if(map.containsKey(word)) { //입력한 단어가 맵에 있음
//				value=map.get(word)+1;
//			}
//			map.put(word, value);
			
//			int value=(map.containsKey(word))==true? map.get(word)+1: 1;
//			map.put(word, value);
		System.out.println(map);
		sc.close();
	}
}
