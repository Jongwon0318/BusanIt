package review_ex;
import java.util.Scanner;

public class Exam10 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 	System.out.println("수를 입력하세요.");
	 	int a=sc.nextInt();
	 	System.out.println("연산자를 입력하세요.");
	 	String b=sc.next();
	 	System.out.println("수를 입력하세요.");
	 	int c=sc.nextInt();
	 	int tmp=a;
	 		if(a<c) {
	 			a=c; c=tmp; //큰수가 앞에 오게하는 방법..!!
	 		}
	 			switch(b) {
	 			case "+":System.out.println(a+b+c+" = "+(a+c)); break;
	 			case "-":System.out.println(a+b+c+" = "+(a-c)); break;
	 			case "*":System.out.println(a+b+c+" = "+(a*c)); break;
	 			case "/":System.out.println(a+b+c+" = "+(a/c)); break;
	 			case "%":System.out.println(a+b+c+" = "+(a%c)); break;
	 			default:System.out.println("연산자 입력오류");
	 			}
 }
}
