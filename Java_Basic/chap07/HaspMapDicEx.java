package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HaspMapDicEx {

	public static void main(String[] args) {
		HashMap<String,String> dic=new HashMap<String,String>();
		dic.put("baby","�Ʊ�");
		dic.put("love", "���");
		dic.put("apple", "���");
		//����ڷκ��� ����ܾ�Է¹ް� �ѱ۴ܾ�Ÿ�, exit�Է¹����� ����
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.print("ã�� ���� �ܾ��? exit�� �Է��ϸ� ����. ");
			String eng=sc.next();
			if(eng.toLowerCase().equals("exit")) {
				System.out.println("�����մϴ�.");
				break;
			}
			String kor=dic.get(eng);
			if(kor==null) {
				System.out.println(eng+"�� ���� �ܾ�");
			}else {
				System.out.println(eng+"�� "+kor);
			}
		}
		sc.close();
	}

}
