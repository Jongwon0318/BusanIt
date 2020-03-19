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
			System.out.println("전화번호 입력 프로그램입니다. '그만'을 입력하면 프로그램 종료.");
			while (true) {
				System.out.print("이름과 전화번호 입력 >> ");
				String str = sc.nextLine();
				if (str.equals("그만")) {
					System.out.println("src\\book_chap08\\phone.txt에 저장하였습니다.");
					break;
				}
				ps.println(str);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} finally {
			sc.close();
			ps.close();
		}
	}

}
