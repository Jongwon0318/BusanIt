package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Mon03 {

	public static void main(String[] args) {
		Scanner sc = null;
		PrintStream ps = null;
		try {
			sc = new Scanner(new File("c:\\windows\\system.ini"));
			ps = new PrintStream(System.out);
			while (sc.hasNextLine()) {
				ps.println(sc.nextLine().toUpperCase());
			}
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} finally {
			sc.close();
			ps.close();
		}
	}

}
