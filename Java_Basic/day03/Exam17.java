package day03;
import java.util.Scanner;

public class Exam17 {
	public static void main(String[] args) {
		//1
		Scanner sc=new Scanner(System.in);
		System.out.println("��� ���� �Է��Ͻðڽ��ϱ�?");
		int num=sc.nextInt();
		System.out.println("�� "+num+"���� �Է��ϼ���.");
		int typ;
		int sum=0;
		for (int i=1; i<=num; i++) {
		  typ=sc.nextInt();
		  sum+=typ;
		}System.out.println("�� "+num+"���� ���� : "+sum);

		//2
		int sum1=0;
		for(int i=0; i<=10; i++) {
			sum1+=i;
		}System.out.println("1���� 10������ �� : "+ sum1);
		int sum2=0;
		for(int i=0; i<=20; i++) {
			sum2+=i;
		}System.out.println("1���� 20������ �� : "+ sum2);
		int sum3=0;
		for(int i=0; i<=30; i++) {
			sum3+=i;
		}System.out.println("1���� 30������ �� : "+ sum3);
		int sum4=0;
		for(int i=0; i<=40; i++) {
			sum4+=i;
		}System.out.println("1���� 40������ �� : "+ sum4);
		int sum5=0;
		for(int i=0; i<=50; i++) {
			sum5+=i;
		}System.out.println("1���� 50������ �� : "+ sum5);
		int sum6=0;
		for(int i=0; i<=60; i++) {
			sum6+=i;
		}System.out.println("1���� 60������ �� : "+ sum6);
		int sum7=0;
		for(int i=0; i<=70; i++) {
			sum7+=i;
		}System.out.println("1���� 70������ �� : "+ sum7);
		int sum8=0;
		for(int i=0; i<=80; i++) {
			sum8+=i;
		}System.out.println("1���� 80������ �� : "+ sum8);
		int sum9=0;
		for(int i=0; i<=90; i++) {
			sum9+=i;
		}System.out.println("1���� 90������ �� : "+ sum9);
		int sum10=0;
		for(int i=0; i<=100; i++) {
			sum10+=i;
		}System.out.println("1���� 100������ �� : "+ sum10);
		System.out.println("\n");

		//3 ???????????????
		int hap=0;
		for(int x=1; x<=10; x++) {
			for(int i=1; i<=10*x; i++) {
			hap+=i;
			}System.out.println("1���� "+10*x+"������ �� : "+ hap);
			hap=0;
		}
		
	    /*answer
		int hap=0;
		for(int i=1; i<=100; i++) {
			hap+=i
			if(i%10==0){System.out.println("1����"+i+"������ ��:"+hap);}
		}
		*/
	
	
	}
}