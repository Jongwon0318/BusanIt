package review_ex;

import java.util.Calendar;
import java.util.Scanner;


public class CalObj {
	public void getAge(Calendar ca,String birth) {
		int year=ca.get(Calendar.YEAR);
		int age=year-1900-Integer.parseInt(birth.substring(0, 2));
		System.out.println("���� : "+age);
	}
	
	public void getBirthday(Calendar ca, String birth) {
		String[] arr= {"��","��","ȭ","��","��","��","��"};
		int year=Integer.parseInt(birth.substring(0, 2));
		int month=Integer.parseInt(birth.substring(2, 4));
		int date=Integer.parseInt(birth.substring(4, 6));
		ca.set(year, month, date);
		System.out.println("���� : "+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
	
	public static void main(String[] args) {
		CalObj obj=new CalObj();
		Scanner sc=new Scanner(System.in);
		System.out.println("��������� �Է��ϼ���. ��)931212");
		String birth=sc.next();
		Calendar ca=Calendar.getInstance();
		try {
			obj.getAge(ca,birth); 		//���� ���ϴ� �޼ҵ�
			obj.getBirthday(ca, birth); 		//���� ���ϴ� �޼ҵ�
		}
		catch(NumberFormatException n) {
			System.out.println("���ڸ� �Է��ϼ���");
		}
	}
}
