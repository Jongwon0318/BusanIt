package review_ex;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest {
//	��������� ���ڷ� �Է¹޾� ���̿� �¾ ���� ������ ���Ͻÿ� ��)931212
//	2019-1900-93
	public static void main(String[] args) {
		Calendar ca=Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("��������� �Է��ϼ���. ��) 931212");
		String birth=sc.next();
		int year=ca.get(Calendar.YEAR);
		int age=year-1900-Integer.parseInt(birth.substring(0, 2));
		System.out.println("���� : "+age);
		
		String[] arr= {"��","��","ȭ","��","��","��","��"};
		int y=Integer.parseInt(birth.substring(0,2));
		int m=Integer.parseInt(birth.substring(2,4));
		int d=Integer.parseInt(birth.substring(4,6));
		ca.set(y, m, d);
		System.out.println("���� : "+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
}
