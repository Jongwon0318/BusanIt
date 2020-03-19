package chap06_2019_11_12;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Mon7_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("문장을 입력하세요. 종료 : exit>>");
			String line = sc.nextLine();
			if(line.toLowerCase().equals("exit")) break;
			StringTokenizer st = new StringTokenizer(line);
			System.out.println("단어 수 : " + st.countTokens());
			while(st.hasMoreTokens()) {
				System.out.println("단어 : " + st.nextToken());
			}
		}
		sc.close();
	}
}
