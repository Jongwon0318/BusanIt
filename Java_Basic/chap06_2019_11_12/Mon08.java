package chap06_2019_11_12;

import java.util.Scanner;

public class Mon08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문장입력");
		String line = sc.nextLine();
		for(int i=0; i<line.length();i++) {
			//첫글자 구하기  ->1  line.charAt(0)
			// 두번째 부터 끝까지 구하기 ->2 line.substring(1)
			// 2+1  line.substring(1)+line.charAt(0)
			//char first = line.charAt(0);
			String first = line.substring(0,1);
			String second =  line.substring(1);
			line = second+first;
			System.out.println(line);
		}
		sc.close();

	}

}
