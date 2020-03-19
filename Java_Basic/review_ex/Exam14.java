package review_ex;
import java.util.Scanner;

public class Exam14 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.print("금액을 입력하세요."+"\t");
	 int money=sc.nextInt();
	 int a=money/50000;
	 int b=money%50000/10000;
	 int c=money%50000%10000/5000;
	 int d=money%50000%10000%5000/1000;
	 int e=money%50000%10000%5000%1000/500;
	 int f=money%50000%10000%5000%1000%500/100;
	 int g=money%50000%10000%5000%1000%500%100/50;
	 int h=money%50000%10000%5000%1000%500%100%50/10;
	 int i=money%50000%10000%5000%1000%500%100%50%10/1;
	 System.out.println("입력하신 금액은 "+money+"원 입니다."+"\n\n"
			 +"=========== 지폐단위 ===========\n\n"
			 +"오만원권 : "+a+"장"+"\n"+"만원권 : "+b+"장"+"\n"
			 +"오천원권 : "+c+"장"+"\n"+"천원권 : "+d+"장"+"\n\n"
			 +"=========== 동전단위 ===========\n\n"
			 +"오백원 : "+e+"개"+"\t"+"백원 : "+f+"개"+"\n"
			 +"오십원 : "+g+"개"+"\t"+"십원 : "+h+"개"+"\t"
			 +"일원 : "+i+"개");
 }
}
