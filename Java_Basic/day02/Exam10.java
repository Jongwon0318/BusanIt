package day02;
import java.util.Scanner;

/*
 * 첫번째 수
 * 두번째 수
 * 연산자 입력
 * 연산자에 해당하는 연산 결과 출력
 * +, -, *,/, %의 다섯가지 이외에 다른값이 들어가면 입력오류 출력
 */

public class Exam10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요.");
		int a = sc.nextInt();
		System.out.print("두번째 수를 입력하세요.");
		int b = sc.nextInt();
		System.out.print("연산자를 입력하세요(+, -, *, /, %).");
		String c = sc.next();
		
		int tmp=a;
		if (a<b){	a=b; b=tmp;}
		else {a=a; b=b;}
		System.out.println("큰 수 : " +a);
		System.out.println("작은 수 : " +b);
		
		switch(c) { //다중 if문을 대신할 수 있는 문장 switch
		case "+":System.out.println(a+c+b+" = "+(a+b)); break;
		case "-":System.out.println(a+c+b+" = "+(a-b)); break;
		case "*":System.out.println(a+c+b+" = "+(a*b)); break;
		case "/":System.out.println(a+c+b+" = "+(a/b)); break;
		case "%":System.out.println(a+c+b+" = "+(a%b)); break;
		default : System.out.println("입력오류");
		}	
		if(c. equals("+")) {  //String==주소비교 / equals==내용비교 
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
			System.out.println("연산자 입력 오류");
		}
	}
}
