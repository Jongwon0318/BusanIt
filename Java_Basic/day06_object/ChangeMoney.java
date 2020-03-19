package day06_object;
import java.util.Scanner;

public class ChangeMoney {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("금액을 입력하세요");
		int don=sc.nextInt();
		int unit[]= {50000,10000,5000,1000,500,100,50,10,1};
		for(int i=0; i<unit.length; i++) {
			int cnt=0;
			cnt=don/unit[i];
			don-=unit[i]*cnt;
			if(cnt!=0)	System.out.println(unit[i]+"원 : "+cnt);
		}
	}
}