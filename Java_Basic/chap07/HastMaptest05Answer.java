package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HastMaptest05Answer {

	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap();
		hm.put("java","1111");
		hm.put("oracle","1234");
		hm.put("jsp","abcd");
		Scanner sc=new Scanner(System.in);
		System.out.println("id/password�� �Է��ϼ���");
		System.out.print("id : ");
		String id=sc.next();
		if(!hm.containsKey(id)) {
			System.out.println("�Է��Ͻ� id�� �����ϴ�");
		}
		System.out.print("password : ");
		String pwd=sc.next();
		//�Է��� id�� ��й�ȣ�� ���ϰ�, �� ��й�ȣ�� ������ �����
		if(hm.get(id).equals(pwd)){
			System.out.println("��� ��ġ");
		}else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
	}

}
