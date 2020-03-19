package review_ex;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest {
//	생년월일을 문자로 입력받아 나이와 태어난 날의 요일을 구하시오 예)931212
//	2019-1900-93
	public static void main(String[] args) {
		Calendar ca=Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("생년월일을 입력하세요. 예) 931212");
		String birth=sc.next();
		int year=ca.get(Calendar.YEAR);
		int age=year-1900-Integer.parseInt(birth.substring(0, 2));
		System.out.println("나이 : "+age);
		
		String[] arr= {"일","월","화","수","목","금","토"};
		int y=Integer.parseInt(birth.substring(0,2));
		int m=Integer.parseInt(birth.substring(2,4));
		int d=Integer.parseInt(birth.substring(4,6));
		ca.set(y, m, d);
		System.out.println("요일 : "+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
}
