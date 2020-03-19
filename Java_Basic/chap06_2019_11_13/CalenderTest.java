package chap06_2019_11_13;
import java.util.Calendar;
import java.util.Scanner;

public class CalenderTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("생년월일을 입력하세요. 예)931212");
		String birth=sc.next(); //931212
		Calendar ca=Calendar.getInstance();
		int year=ca.get(Calendar.YEAR); //2019를 구해줌
		int age=year-1900-Integer.parseInt(birth.substring(0,2));
		System.out.println("나이 : "+age);
		//요일구하기
		String[] arr
		= {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		//ca.set(1993,11,12); //1993 12 12 set(int a,int b,int c)
		int y=Integer.parseInt(birth.substring(0,2))+1900;
		int m=Integer.parseInt(birth.substring(2,4))-1; //substring (커서1)0 1 2 3 4 5
		int d=Integer.parseInt(birth.substring(4,6));
		ca.set(y,m,d);
		System.out.println("요일 : "
				+arr[ca.get(Calendar.DAY_OF_WEEK)-1]);
	}
}