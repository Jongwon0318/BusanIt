package chap08_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Mon05 {

	public static void main(String[] args) {
		Scanner sc = null;
//		Scanner sc2 = null;
		FileInputStream f1 = null;
		FileInputStream f2 = null;

		System.out.println("��ü ��θ��� �ƴ� ���� �̸��� �Է��ϴ� ���, ������ ������Ʈ ������ �־�� �մϴ�.");
		sc = new Scanner(System.in);
		System.out.print("ù��° ���� �̸��� �Է��ϼ���.>>");
		String firstfile = sc.next();
		System.out.print("�ι�° ���� �̸��� �Է��ϼ���.>>");
		String secondfile = sc.next();
		sc.close();
		System.out.println(firstfile + "�� " + secondfile + "�� ���մϴ�.");
		try {
//			sc = new Scanner(new File("src\\book_chap08\\" + firstfile));
//			sc2 = new Scanner(new File("src\\book_chap08\\" + secondfile));

			f1 = new FileInputStream(new File("src\\book_chap08\\" + firstfile));
			f2 = new FileInputStream(new File("src\\book_chap08\\" + secondfile));

//			StringBuffer sb=new StringBuffer(1024);
//			while (sc.hasNextLine()) {
//				String scstr = sc.nextLine();
//				String scstr2 = sc2.nextLine();
//				if (scstr.equals(scstr2)) {
//					System.out.print("�� ������ �����ϴ�.");
//				} else {
//					System.out.print("�� ������ �ٸ��ϴ�.");
//					break;
//				}
//			}
//			int c;
//			f1.equals(f2);
//			while((c=f1.read())!=-1) {
//				if(c==f2.read()) {
//					System.out.print("�� ������ �����ϴ�.");
//				}else {
//					System.out.print("�� ������ �ٸ��ϴ�.");
//				}
//			}

			if (f1.equals(f2)) {
				System.out.print("�� ������ �����ϴ�.");
			} else {
				System.out.print("�� ������ �ٸ��ϴ�.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		} 

	}
}