package day07;
import java.util.Scanner;

public class Mon_Chap03_16 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���� ���� �� ������ �մϴ�.");

		
		while(true) {
			double r=Math.random();
			System.out.println("���� ���� ��! >>");
			String a=sc.next();
			System.out.println("����� : "+a);

			if(r<0.33) {
				System.out.println("��ǻ�� : "+"����"); continue;
			}else if(r<0.66) {
				System.out.println("��ǻ�� : "+"����"); continue;
			}else{
				System.out.println("��ǻ�� : "+"��"); continue;
			}
		}
		
	}
}
