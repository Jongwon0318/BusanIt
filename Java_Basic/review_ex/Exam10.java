package review_ex;
import java.util.Scanner;

public class Exam10 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 	System.out.println("���� �Է��ϼ���.");
	 	int a=sc.nextInt();
	 	System.out.println("�����ڸ� �Է��ϼ���.");
	 	String b=sc.next();
	 	System.out.println("���� �Է��ϼ���.");
	 	int c=sc.nextInt();
	 	int tmp=a;
	 		if(a<c) {
	 			a=c; c=tmp; //ū���� �տ� �����ϴ� ���..!!
	 		}
	 			switch(b) {
	 			case "+":System.out.println(a+b+c+" = "+(a+c)); break;
	 			case "-":System.out.println(a+b+c+" = "+(a-c)); break;
	 			case "*":System.out.println(a+b+c+" = "+(a*c)); break;
	 			case "/":System.out.println(a+b+c+" = "+(a/c)); break;
	 			case "%":System.out.println(a+b+c+" = "+(a%c)); break;
	 			default:System.out.println("������ �Է¿���");
	 			}
 }
}
