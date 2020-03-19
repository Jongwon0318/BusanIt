package chap07_book;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class Nation {
	String country;
	String capital;

	public Nation(String country, String capital) {
		super();
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		return country;
	}

	public String getCapital() {
		return capital;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

}

public class Mon11_02 {
	HashMap<String,String> map=new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	
	public void menu() {
		System.out.print("�Է�:1,  ����:2,  ����:3 >>");
	}
	
	public void input() {
		System.out.println("���� "+map.size()+"�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		System.out.print("����� ���� �Է�"+map.size()+" >>");
		String line=sc.nextLine();
		String[] arr=line.split(" ");
		Nation na=new Nation(arr[0],arr[1]);
		if(map.containsKey(arr[0])) System.out.println(arr[0]+": �̹� �ֽ��ϴ�!!");
		else map.put(arr[0], arr[1]);
	}
	
	public void quiz() {
		Set<String> set=map.keySet();
		Object[] arr=(String[])set.toArray();
		while(true) {
			int r=(int)Math.random()*map.size();
			System.out.println(arr[r]+"�� ������?");
			
		}
	}
	
	public static void main(String[] args) {
		Mon11_02 mon=new Mon11_02();
		System.out.println("****���� ���߱� ������ �����մϴ�. ****");
		while(true) {
			mon.menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1: mon.input();
			case 2: mon.quiz();
			case 3: System.out.println("���α׷��� �����մϴ�.");
							System.exit(0);
			default : System.out.println("���ù�ȣ �Է� ����");
			}
		}
				
	}

}
