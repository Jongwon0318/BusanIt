package chap06_2019_11_13;
import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��������� �Է��ϼ���. ��)931212");
		String birth=sc.next(); //931212
		Calendar ca=Calendar.getInstance();
		int year=ca.get(Calendar.YEAR); //2019�� ������
		int age=year-1900-Integer.parseInt(birth.substring(0,2));
		System.out.println("���� : "+age);
		//���ϱ��ϱ�
		String[] arr
		= {"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
		//ca.set(1993,11,12); //1993 12 12 set(int a,int b,int c)
		int y=Integer.parseInt(birth.substring(0,2))+1900;
		int m=Integer.parseInt(birth.substring(2,4))-1; //substring (Ŀ��1)0 1 2 3 4 5
		int d=Integer.parseInt(birth.substring(4,6));
		ca.set(y,m,d);
		System.out.println("���� : "
				+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
}