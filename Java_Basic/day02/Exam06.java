package day02;
import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("이름 : ");
		String name = sc.next(); // 입력한 문자를 받아오는 함수 next
				
		System.out.println("나이 : ");
		int age = sc.nextInt(); // 입력한 숫자를 받아오는 함수 nextInt
		
		System.out.println("이름 : " +name+"\n"+"나이 : " + age);
	}
}
