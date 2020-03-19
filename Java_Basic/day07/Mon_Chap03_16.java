package day07;
import java.util.Scanner;

public class Mon_Chap03_16 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");

		
		while(true) {
			double r=Math.random();
			System.out.println("가위 바위 보! >>");
			String a=sc.next();
			System.out.println("사용자 : "+a);

			if(r<0.33) {
				System.out.println("컴퓨터 : "+"가위"); continue;
			}else if(r<0.66) {
				System.out.println("컴퓨터 : "+"바위"); continue;
			}else{
				System.out.println("컴퓨터 : "+"보"); continue;
			}
		}
		
	}
}
