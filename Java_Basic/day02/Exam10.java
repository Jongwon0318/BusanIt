package day02;
import java.util.Scanner;

/*
 * ù��° ��
 * �ι�° ��
 * ������ �Է�
 * �����ڿ� �ش��ϴ� ���� ��� ���
 * +, -, *,/, %�� �ټ����� �̿ܿ� �ٸ����� ���� �Է¿��� ���
 */

public class Exam10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("ù��° ���� �Է��ϼ���.");
		int a = sc.nextInt();
		System.out.print("�ι�° ���� �Է��ϼ���.");
		int b = sc.nextInt();
		System.out.print("�����ڸ� �Է��ϼ���(+, -, *, /, %).");
		String c = sc.next();
		
		int tmp=a;
		if (a<b){	a=b; b=tmp;}
		else {a=a; b=b;}
		System.out.println("ū �� : " +a);
		System.out.println("���� �� : " +b);
		
		switch(c) { //���� if���� ����� �� �ִ� ���� switch
		case "+":System.out.println(a+c+b+" = "+(a+b)); break;
		case "-":System.out.println(a+c+b+" = "+(a-b)); break;
		case "*":System.out.println(a+c+b+" = "+(a*b)); break;
		case "/":System.out.println(a+c+b+" = "+(a/b)); break;
		case "%":System.out.println(a+c+b+" = "+(a%b)); break;
		default : System.out.println("�Է¿���");
		}	
		if(c. equals("+")) {  //String==�ּҺ� / equals==����� 
			System.out.println(a+c+b+" = "+(a+b));
		}else if(c.equals("-")) {
			System.out.println(a+c+b+"="+(a-b));
		}else if(c.equals("*")) {
			System.out.println(a+c+b+" = "+(a*b));
		}else if(c.equals("/")) {
			System.out.println(a+c+b+" = "+(a/b));	
		}else if(c.equals("%")) {
			System.out.println(a+c+b+"="+(a%b));	
		}else {
			System.out.println("������ �Է� ����");
		}
	}
}
