package review_ex;

import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest_Re {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Calendar ca=Calendar.getInstance();
		System.out.println("생년월일을 입력하세요. 예)930312");
		String birth=sc.next();
		String[] arr= {"일","월","화","수","목","금","토"};

		int thisyear=ca.get(Calendar.YEAR);
		int year=Integer.parseInt(birth.substring(0,2));
		int month=Integer.parseInt(birth.substring(2,4));
		int date=Integer.parseInt(birth.substring(4,6));
		ca.set(year, month, date);
		System.out.println("나이 : "+(thisyear-1900-year+1));
		System.out.println("태어난 날의 요일 : "+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
}