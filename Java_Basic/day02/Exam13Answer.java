package day02;
import java.util.Scanner;

public class Exam13Answer {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 System.out.println("1~99���� ������ �Է��Ͻÿ�");
	 int num=sc.nextInt();
	 int a = num/10;
	 int b = num%10;
	 int cnt = 0;
	 	 
	 if(a !=0 && a%3==0) { //a�� 0�� �ƴϰ� 3���� ���������� ��
		 cnt++;
	 }
	 if(b !=0 && b%3==0) { //b�� 0�� �ƴϰ� 3���� ���������� ��
		 cnt++;
	 } //if(a==3||a==6||a==9){}
	 if(cnt==2) {
		 System.out.println("�ڼ�¦¦");
	 }else if(cnt==1) {
		 System.out.println("�ڼ�¦");
	 }else {
		 System.out.println("�ڼ�����");
	 }
 }
}