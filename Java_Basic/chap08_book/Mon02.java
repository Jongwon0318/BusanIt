package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mon02 {

	public static void main(String[] args) {
		Scanner sc = null;
		File f=new File("src\\book_chap08\\phone.txt");
		try {
			sc = new Scanner(f);
			System.out.println(f.getPath()+"�� ����մϴ�.");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} finally {
			sc.close();
		}
	}

}
