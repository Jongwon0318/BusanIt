package chap04_book;
import java.util.Scanner;

import day08.Teacher;

public class Test03 {
	Song[] arr=new Song[3];
	int cnt;
	public void input() {
		System.out.println("�뷡 3���� ������ �Է��ϼ���.");
		while(true) {
			System.out.println("�߸ų⵵�� �Է��ϼ���.");
			int year=Teacher.sc.nextInt();
			System.out.println("��Ƽ��Ʈ�� �Է��ϼ���.");
			String artist=Teacher.sc.next();
			System.out.println("������ �Է��ϼ���.");
			String country=Teacher.sc.next();
			System.out.println("������ �Է��ϼ���.");
			String title=Teacher.sc.next();
			arr[cnt++]=new Song(title,artist,country,year);
			if (cnt==3) break;
		}
	}
	
	public void view() {
		for(int i=0; i<arr.length; i++) arr[i].show();
	}
	
	public static void main(String[] args) {
		Test03 test=new Test03();
		test.input(); //�Է�
		test.view(); //���
	}
}
