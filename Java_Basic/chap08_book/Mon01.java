package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Mon01 {

	public static void main(String[] args) {
		Scanner sc = null;
		PrintStream ps = null;
		try {
			sc = new Scanner(System.in);
			ps = new PrintStream(new File("src\\book_chap08\\phone.txt"));
			System.out.println("��ȭ��ȣ �Է� ���α׷��Դϴ�. '�׸�'�� �Է��ϸ� ���α׷� ����.");
			while (true) {
				System.out.print("�̸��� ��ȭ��ȣ �Է� >> ");
				String str = sc.nextLine();
				if (str.equals("�׸�")) {
					System.out.println("src\\book_chap08\\phone.txt�� �����Ͽ����ϴ�.");
					break;
				}
				ps.println(str);
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ �����ϴ�.");
		} finally {
			sc.close();
			ps.close();
		}
	}

}
