package day03;
import java.util.Scanner;

public class Exam17answer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("입력할 갯수를 지정하세요.");
		int input=sc.nextInt(); //3 5 7
		int sum=0;
			System.out.println("데이터 입력 : ");
		for(int i=0; i<input; i++) { //보통 프로그래밍에서는 0부터 준다
			int inData=sc.nextInt();
			sum+=inData;
		}System.out.println("입력합계 : "+sum);
	}
}
