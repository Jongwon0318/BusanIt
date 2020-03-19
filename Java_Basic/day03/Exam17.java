package day03;
import java.util.Scanner;

public class Exam17 {
	public static void main(String[] args) {
		//1
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 수를 입력하시겠습니까?");
		int num=sc.nextInt();
		System.out.println("수 "+num+"개를 입력하세요.");
		int typ;
		int sum=0;
		for (int i=1; i<=num; i++) {
		  typ=sc.nextInt();
		  sum+=typ;
		}System.out.println("수 "+num+"개의 합은 : "+sum);

		//2
		int sum1=0;
		for(int i=0; i<=10; i++) {
			sum1+=i;
		}System.out.println("1부터 10까지의 합 : "+ sum1);
		int sum2=0;
		for(int i=0; i<=20; i++) {
			sum2+=i;
		}System.out.println("1부터 20까지의 합 : "+ sum2);
		int sum3=0;
		for(int i=0; i<=30; i++) {
			sum3+=i;
		}System.out.println("1부터 30까지의 합 : "+ sum3);
		int sum4=0;
		for(int i=0; i<=40; i++) {
			sum4+=i;
		}System.out.println("1부터 40까지의 합 : "+ sum4);
		int sum5=0;
		for(int i=0; i<=50; i++) {
			sum5+=i;
		}System.out.println("1부터 50까지의 합 : "+ sum5);
		int sum6=0;
		for(int i=0; i<=60; i++) {
			sum6+=i;
		}System.out.println("1부터 60까지의 합 : "+ sum6);
		int sum7=0;
		for(int i=0; i<=70; i++) {
			sum7+=i;
		}System.out.println("1부터 70까지의 합 : "+ sum7);
		int sum8=0;
		for(int i=0; i<=80; i++) {
			sum8+=i;
		}System.out.println("1부터 80까지의 합 : "+ sum8);
		int sum9=0;
		for(int i=0; i<=90; i++) {
			sum9+=i;
		}System.out.println("1부터 90까지의 합 : "+ sum9);
		int sum10=0;
		for(int i=0; i<=100; i++) {
			sum10+=i;
		}System.out.println("1부터 100까지의 합 : "+ sum10);
		System.out.println("\n");

		//3 ???????????????
		int hap=0;
		for(int x=1; x<=10; x++) {
			for(int i=1; i<=10*x; i++) {
			hap+=i;
			}System.out.println("1부터 "+10*x+"까지의 합 : "+ hap);
			hap=0;
		}
		
	    /*answer
		int hap=0;
		for(int i=1; i<=100; i++) {
			hap+=i
			if(i%10==0){System.out.println("1부터"+i+"까지의 합:"+hap);}
		}
		*/
	
	
	}
}