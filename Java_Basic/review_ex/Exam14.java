package review_ex;
import java.util.Scanner;

public class Exam14 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.print("�ݾ��� �Է��ϼ���."+"\t");
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
	 System.out.println("�Է��Ͻ� �ݾ��� "+money+"�� �Դϴ�."+"\n\n"
			 +"=========== ������� ===========\n\n"
			 +"�������� : "+a+"��"+"\n"+"������ : "+b+"��"+"\n"
			 +"��õ���� : "+c+"��"+"\n"+"õ���� : "+d+"��"+"\n\n"
			 +"=========== �������� ===========\n\n"
			 +"����� : "+e+"��"+"\t"+"��� : "+f+"��"+"\n"
			 +"���ʿ� : "+g+"��"+"\t"+"�ʿ� : "+h+"��"+"\t"
			 +"�Ͽ� : "+i+"��");
 }
}
