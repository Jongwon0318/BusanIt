package day02;
import java.util.Scanner;
/*
 * �� ���� �Է¹޾�
 * ū��, ������, �� ���� ���̸� ���
 * ��,���̴� ū������ ���� �� ����(���)
 */
public class Exam09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ���");
		int a=sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���");
		int b=sc.nextInt();
		if(a>=b) {
			System.out.print("�� ���� ���̴� : "+(a-b)+"\n");
		}else {
			System.out.print("�� ���� ���̴� "+(b-a)+"\n");
		}
		
		if(a>b) {
			System.out.print("�� ū ���ڴ� ù��° ���̴�.");
		}else if(a==b) {
			System.out.print("ù��° ���� �ι�° ���� ����.");
		}else {
			System.out.print("�� ū ���ڴ� �ι�° ���̴�.");
		}
	}
}

//if(num1>num2) { System.out.println("ū �� : " +num1+"���� �� : "+num2+"���� "+(num1-num2)}
//else if ~~~~
//else~~~~