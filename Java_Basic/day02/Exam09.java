package day02;
import java.util.Scanner;
/*
 * 두 수를 입력받아
 * 큰수, 작은수, 두 수의 차이를 출력
 * 단,차이는 큰수에서 작은 수 빼기(양수)
 */
public class Exam09 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력하세요");
		int a=sc.nextInt();
		System.out.print("두번째 수를 입력하세요");
		int b=sc.nextInt();
		if(a>=b) {
			System.out.print("두 수의 차이는 : "+(a-b)+"\n");
		}else {
			System.out.print("두 수의 차이는 "+(b-a)+"\n");
		}
		
		if(a>b) {
			System.out.print("더 큰 숫자는 첫번째 수이다.");
		}else if(a==b) {
			System.out.print("첫번째 수와 두번째 수는 같다.");
		}else {
			System.out.print("더 큰 숫자는 두번째 수이다.");
		}
	}
}

//if(num1>num2) { System.out.println("큰 수 : " +num1+"작은 수 : "+num2+"차이 "+(num1-num2)}
//else if ~~~~
//else~~~~