package day03;
import java.util.Scanner;

public class Exam17answer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�Է��� ������ �����ϼ���.");
		int input=sc.nextInt(); //3 5 7
		int sum=0;
			System.out.println("������ �Է� : ");
		for(int i=0; i<input; i++) { //���� ���α׷��ֿ����� 0���� �ش�
			int inData=sc.nextInt();
			sum+=inData;
		}System.out.println("�Է��հ� : "+sum);
	}
}
