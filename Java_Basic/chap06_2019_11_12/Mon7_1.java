package chap06_2019_11_12;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Mon7_1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("������ �Է��ϼ���. ���� : exit>>");
			String line = sc.nextLine();
			if(line.toLowerCase().equals("exit")) break;
			StringTokenizer st = new StringTokenizer(line);
			System.out.println("�ܾ� �� : " + st.countTokens());
			while(st.hasMoreTokens()) {
				System.out.println("�ܾ� : " + st.nextToken());
			}
		}
		sc.close();
	}
}
