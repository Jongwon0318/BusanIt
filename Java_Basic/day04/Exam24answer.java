package day04;
import java.util.Scanner;

public class Exam24answer {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�Է��� ���� �Է� : ");
		int cnt = sc.nextInt();
		System.out.println("������ �Է� : ");
		int eSum=0; //¦����
		int oSum=0; //Ȧ����
		for(int i=0; i<cnt; i++) {
			int su = sc.nextInt();
			if(su%2==0) {
				eSum+=su;
			}else {
				oSum+=su;
			}
		}System.out.println("¦���� �� : "+eSum);
		System.out.println("Ȧ���� �� : "+oSum);
	}
}
