package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest05 {

	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap();
		hm.put("java","1111");
		hm.put("oracle","1234");
		hm.put("jsp","abcd");
		Scanner sc=new Scanner(System.in);
		//�Է��Ͻ� id�� �����ϴ� , ��й�ȣ�� ��ġ���� �ʽ��ϴ�, ��� ��ġ
		System.out.println("id/password�� �Է��ϼ���");
		System.out.print("id : ");
		String id=sc.next();
		System.out.print("password : ");
		String pwd=sc.next();
		
		if(hm.containsKey(id)) 
		{
			//hm.get(id).equals(pwd) ? System.out.println("��� ��ġ") : System.out.println("��й�ȣ ����ġ");
		}else {
			System.out.println("�Է��Ͻ� ���̵� �����ϴ�.");
		}

	}
}