package review_ex;
import java.util.Scanner;

public class Exam13 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 	System.out.println("1~99������ ������ �Է��ϼ���.");
	 		int num=sc.nextInt();
	 		int a=num/10;
	 		int b=num%10;
	 		int cnt=0;
	 			if(a!=0 && a%3==0) {
	 				cnt++;
	 			}if(b!=0 && b%3==0) {
	 				cnt++;
	 			}
	 				switch(cnt) {
	 				case 2: System.out.println("�ڼ�¦¦"); break;
	 				case 1: System.out.println("�ڼ�¦"); break;
	 				default: System.out.println("�ڼ�����");
	 				}
 }
}