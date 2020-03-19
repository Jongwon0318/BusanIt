package review_ex;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03_Re {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap <String,Integer> hm=new HashMap();
		while(true) {
			System.out.println("단어를 입력하세요. x를 입력하면 종료됩니다.");
			String word=sc.next();
			if(word.toLowerCase().equals("x")) break;
			hm.put(word,hm.containsKey(word)? hm.get(word)+1:1);
		}
		System.out.println(hm);
	}
}
