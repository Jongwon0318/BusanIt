package day06_object;
import java.util.Scanner;

public class Exam38 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("가로 길이를 입력하세요.");
		int wid=sc.nextInt();
		System.out.println("세로 길이를 입력하세요.");
		int hei=sc.nextInt();
		if(wid<=0 || hei<=0)	System.out.println("입력이 잘못되었습니다.");
		else 	System.out.println("사각형의 넓이 : "+wid*hei);
	}
public class Rectangular{
		
	}
}