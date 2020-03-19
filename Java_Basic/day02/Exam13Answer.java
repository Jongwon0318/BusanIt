package day02;
import java.util.Scanner;

public class Exam13Answer {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("1~99사이 정수를 입력하시오");
	 int num=sc.nextInt();
	 int a = num/10;
	 int b = num%10;
	 int cnt = 0;
	 	 
	 if(a !=0 && a%3==0) { //a가 0이 아니고 3으로 나누어지는 수
		 cnt++;
	 }
	 if(b !=0 && b%3==0) { //b가 0이 아니고 3으로 나누어지는 수
		 cnt++;
	 } //if(a==3||a==6||a==9){}
	 if(cnt==2) {
		 System.out.println("박수짝짝");
	 }else if(cnt==1) {
		 System.out.println("박수짝");
	 }else {
		 System.out.println("박수없음");
	 }
 }
}