package review_ex;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicex {

	public static void main(String[] args) {
		HashMap<String,String> dic=new HashMap<String,String>();
		dic.put("baby","�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");

		//����ڷκ��� ����ܾ�Է¹ް� �ѱ۴ܾ�Ÿ�, exit�Է¹����� ����
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("���ܾ �Է��ϼ���. exit�� �Է��ϸ� ����˴ϴ�.");
			String word=sc.next();
			if(word.toLowerCase().equals("exit")) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			if(dic.containsKey(word)==false) {
				System.out.println("�Է��Ͻ� �ܾ �����ϴ�.");
			}else {
				System.out.println(dic.get(word));
			}
		}
	}

}
