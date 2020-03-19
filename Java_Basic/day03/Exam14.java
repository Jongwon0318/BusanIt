package day03;
import java.util.Scanner;

public class Exam14 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	  System.out.println("금액을 입력하세요.");
	  int money=sc.nextInt();
	                   //65376 1, 1, 5, 3, 1, 2, 6
	  int a=money/50000;
	  int b=(money-50000*a)/10000;
	  int c=(money-50000*a-10000*b)/1000;
	  int d=(money-50000*a-10000*b-1000*c)/100;
	  int e=(money-50000*a-10000*b-1000*c-100*d)/50;
	  int f=(money-50000*a-10000*b-1000*c-100*d-50*e)/10;
	  int g=(money-50000*a-10000*b-1000*c-100*d-50*e-10*f)/1;
		  System.out.println("\n"+"오만원권 : "+a+"장"+"\n"+"만원권 : "+b+"장"+"\n"+"천원권 : "+c+"장"+"\n"
				  +"백원 : "+d+"개"+"\n"+"오십원 : "+e+"개"+"\n"+"십원 : "+f+"개"+"\n"+"일원 : "+g+"개"+"\n");
 }
}
/* int a=money/50000
*  int b=(money%50000)/10000
*  int c=(money%50000%10000)/1000
*  int d=(money%50000%10000%1000)/100
*  int e=(money%50000%10000%1000%100)/50
*  int f=
*  
*  
*  int result=money/50000; // 5만원권
*  money = money%50000; //원금 15376
*  System.out.println("5만원권 :" + result);
*  result = money/10000;
*  money = money%10000;
*  System.out.println("1만원권 :" + result);
*  result =money/1000;
*  money =money%1000;
*  System.out.println("천원권 :"+result);
*  result = money/100;
*  money = money%100;
*  System.out.println("백원 :"+result);
*  result = money/50;
*  money = money%50;
*  System.out.println("오십원 :"+result);
*  result = money/10;
*  money = money%10;
*  System.out.println("십원 :"+result);
*  result = money/1;
*  *  System.out.println("일원 :"+result);
*/