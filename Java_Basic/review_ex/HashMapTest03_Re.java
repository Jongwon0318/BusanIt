package review_ex;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03_Re {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap <String,Integer> hm=new HashMap();
		while(true) {
			System.out.println("�ܾ �Է��ϼ���. x�� �Է��ϸ� ����˴ϴ�.");
			String word=sc.next();
			if(word.toLowerCase().equals("x")) break;
			hm.put(word,hm.containsKey(word)? hm.get(word)+1:1);
		}
		System.out.println(hm);
	}
}
