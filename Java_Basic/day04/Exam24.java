package day04;
import java.util.Scanner;

public class Exam24 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("원하는 수를 입력하시오.");
		int num=sc.nextInt();
		int sum=0;
		int hap=0;
		for(int i=0; i<=num; i++) {
		if(i%2==0) sum+=i;
		if(i%2==1) hap+=i;
		}
		System.out.println(num+"까지의 짝수의 합 : "+sum);
		System.out.println(num+"까지의 홀수의 합 : "+hap);
	}
}