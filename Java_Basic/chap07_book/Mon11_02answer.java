package chap07_book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Mon11_02answer {
	HashMap<String, String> map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	public Mon11_02answer() {
		map.put("�ѱ�","����");
		map.put("�Ϻ�","����");
		map.put("�߱�","����¡");
		map.put("����","������");
	}
	public static void showMenu() {
		System.out.println("****���� ���߱� ������ �����մϴ�****");
		System.out.print("�Է�:1,  ����:2,  ����:3 >>");
	}

	public void input() {
		System.out.println("����"+map.size()+"�� ����� ���� ���");
		while(true) {
			System.out.print("����� ���� �Է�..����� x>>");
			String str=sc.next(); //����
			if(str.toLowerCase().equals("x")) break;
			if(map.containsKey(str)) {
				System.out.println("�̹� ��ϵ� ����");
				continue;
			}
			String str1=sc.next();//����
			map.put(str, str1);
		}
	}

	public void quiz() {
		Set<String> set=map.keySet();
		Object[] arr=set.toArray();
//		Iterator<String> it=set.iterator();
//		int i=0;
//		String[] arr=new String[set.size()];
//		while(it.hasNext()) {
//			arr[i]=it.next();
//			i++;
//		}
		while(true) {
			int r=(int)(Math.random()*set.size());
			String mon=(String)arr[r]; //����
			String dap=map.get(arr[r]); //��
			
			//��������
			System.out.println(mon+"�� ������? ����� x");
			String city=sc.next();
			if(city.toLowerCase().equals("x")) break;
			if(city.equals(dap)) {
				System.out.println("�����Դϴ�.");
			}else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}
		}
		
	}

	public static void main(String[] args) {
		Mon11_02answer test = new Mon11_02answer();
		while (true) {
			Mon11_02answer.showMenu();
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				test.input();
			case 2:
				test.quiz();
			case 3:
				System.out.println("����");
				System.exit(0);
			default:
				System.out.println("�Է¿���");
			}
		}
	}

}
