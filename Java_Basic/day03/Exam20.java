package day03;
import java.util.Scanner;
//몇개입력받을지모르니까 for문은 애매하다.--->while문을 쓴다.
public class Exam20 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
				
		System.out.println("양수를 입력하세요. -1을 입력하면 수 입력이 종료됩니다.");
		int sum=0;
		int cnt=0; //cnt = 입력한 수의 갯수
		while(true) { // while(true){} : 무한루프, {}안에 조건을 만들어 주어서 조건에 빠지게 만들어준다.
			int num=sc.nextInt();
			if(num== -1) break; //반복문을 그만두는것, break나 continue는 블럭을 설정할 필요가 없다.
			
			cnt++; //wow
			sum+=num; //합계
			int avg=sum/cnt; //cnt = 입력한 수의 갯수
			
		}System.out.println("합계 : "+sum+"\t"+"평균 : "+sum/cnt);
	}
}