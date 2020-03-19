package day04;
import java.util.Scanner;

public class Exam24answer {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("입력할 갯수 입력 : ");
		int cnt = sc.nextInt();
		System.out.println("데이터 입력 : ");
		int eSum=0; //짝수합
		int oSum=0; //홀수합
		for(int i=0; i<cnt; i++) {
			int su = sc.nextInt();
			if(su%2==0) {
				eSum+=su;
			}else {
				oSum+=su;
			}
		}System.out.println("짝수의 합 : "+eSum);
		System.out.println("홀수의 합 : "+oSum);
	}
}
