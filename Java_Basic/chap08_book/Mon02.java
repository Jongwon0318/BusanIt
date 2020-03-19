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
			System.out.println(f.getPath()+"를 출력합니다.");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		} finally {
			sc.close();
		}
	}

}
