package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest03 {

	public static void main(String[] args) {
		//1.�ؽ��� map�� ����
		//2.�ܾ �Է¹޾� �ܾ�� �Է� Ƚ���� ����
		//3.��ҹ��ڱ��о��� xġ�� ����.
		//4.map ���
//		HashMap<String,Integer> map=new HashMap<String, Integer>();
//		Scanner sc=new Scanner(System.in);
//		while(true) {
//			System.out.println("�ܾ �Է��ϼ���... X�� �Է��ϸ� ����˴ϴ�.");
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
			System.out.println("�ܾ� �Է�, ����� x");
			String word=sc.next();
//			int value=1;
			if(word.toLowerCase().equals("x")) break;
			map.put(word, (map.containsKey(word))==true? map.get(word)+1: 1);
		}
//			
//			if(map.containsKey(word)) { //�Է��� �ܾ �ʿ� ����
//				value=map.get(word)+1;
//			}
//			map.put(word, value);
			
//			int value=(map.containsKey(word))==true? map.get(word)+1: 1;
//			map.put(word, value);
		System.out.println(map);
		sc.close();
	}
}
