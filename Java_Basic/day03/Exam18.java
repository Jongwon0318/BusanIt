package day03;
import java.util.Scanner;
//2
public class Exam18 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("�л� ���� �Է��Ͻÿ�.");
	 int num=sc.nextInt();
	 System.out.println("���ٿ� ���� �л��� ���� �Է��Ͻÿ�.");
	 int line=sc.nextInt();
	 System.out.println("\n"+"�¼���ġ��"+"\n");
	 for(int i=1; i<=num; i++) {
		System.out.print(i+"\t");
		if(i%line==0) System.out.print("\n");
		
	 }
	 /*int row=num/line;
	 if(num%line!=0)  //if���� �ɷ��ִ� ���� �����̶�� {}�� ������ �ȴ�.
		 row=row+1;
		 */
	 //���׿�����(���ǿ�����) ---> ���� = ���� ?  �������� : ������ ���� ;
	  //row= �л����� �����л����� ����������°� ?  ����������� : ������������ʴ´�. ;
	 int  row=(num/line==0)? num/line: num/line+1;
	 System.out.println("\n"+"���� �� : "+row);
 }
}