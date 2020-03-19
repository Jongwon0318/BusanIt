package day02;
import java.util.Scanner;
//숫자 하나를 입력받아 그 숫자가 짝수인지 홀수인지 구분하시오.
public class Exam07 {
	public static void main(String[] args){
		
		Scanner scn = new Scanner (System.in);
		System.out.print("숫자를 입력하세요");
		int x = scn.nextInt(); 
		System.out.print("숫자  " +x+" : ");
		if(x%2==0){
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		}
}