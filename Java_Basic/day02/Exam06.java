package day02;
import java.util.Scanner;

public class Exam06 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("�̸� : ");
		String name = sc.next(); // �Է��� ���ڸ� �޾ƿ��� �Լ� next
				
		System.out.println("���� : ");
		int age = sc.nextInt(); // �Է��� ���ڸ� �޾ƿ��� �Լ� nextInt
		
		System.out.println("�̸� : " +name+"\n"+"���� : " + age);
	}
}
