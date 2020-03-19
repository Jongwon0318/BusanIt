package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Mon04 {

	public static void main(String[] args) {
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
		Scanner sc = null;
		PrintStream ps = null;
		try {
			sc = new Scanner(new File("c:\\windows\\system.ini"));
			ps = new PrintStream(System.out);
			int cnt = 1;
			while (sc.hasNextLine()) {
				ps.println(cnt + " : " + sc.nextLine());
				cnt++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		}

	}

}
