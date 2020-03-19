package chap06_2019_11_13;

import java.util.Calendar;
import java.util.Scanner;

public class CalObj {
	
	
	private void getAge(Calendar ca, String birth) {
		int year=ca.get(Calendar.YEAR); //2019를 구해줌
		int age=year-1900-Integer.parseInt(birth.substring(0,2));
		System.out.println("나이 : "+age);
	}
		
	public void getBirthday(Calendar ca, String birth) {
		String[] arr
		= {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		int y=Integer.parseInt(birth.substring(0,2))+1900;
		int m=Integer.parseInt(birth.substring(2,4))-1; //substring (커서1)0 1 2 3 4 5
		int d=Integer.parseInt(birth.substring(4,6));
		ca.set(y,m,d);
		System.out.println("요일 : "
				+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
	
	public static void main(String[] args) {
		CalObj obj=new CalObj();
		Scanner sc=new Scanner(System.in);
		System.out.println("생년월일을 입력하세요. 예)931212");
		String birth=sc.next();
		Calendar ca=Calendar.getInstance();
		try {
			obj.getAge(ca,birth); 		//나이 구하는 메소드
			obj.getBirthday(ca, birth); 		//요일 구하는 메소드
		}
		catch(NumberFormatException n) {
			System.out.println("숫자를 입력하세요");
		}
	}
}