package review_ex;

import java.util.HashMap;
import java.util.Scanner;

//1.�ؽ��� map�� ����
//2.�ܾ �Է¹޾� �ܾ�� �Է� Ƚ���� ����
//3.��ҹ��ڱ��о��� xġ�� ����.
//4.map ���
public class HashMapTest03 {
	public static void main(String[] args) {
		HashMap<String, Integer>hm=new HashMap();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("�ܾ �Է��ϼ���. x�� �Է��ϸ� ����˴ϴ�.");
			String word=sc.next();
			if(word.toLowerCase().equals("x")) break;
			hm.put(word, hm.containsValue(hm.get(word))? hm.get(word)+1 : 1);
		}
		System.out.println(hm);
	}
}
