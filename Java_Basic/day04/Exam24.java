package day04;
import java.util.Scanner;

public class Exam24 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���� �Է��Ͻÿ�.");
		int num=sc.nextInt();
		int sum=0;
		int hap=0;
		for(int i=0; i<=num; i++) {
		if(i%2==0) sum+=i;
		if(i%2==1) hap+=i;
		}
		System.out.println(num+"������ ¦���� �� : "+sum);
		System.out.println(num+"������ Ȧ���� �� : "+hap);
	}
}