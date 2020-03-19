package chap04_book;
import java.util.Scanner;

public class Grade {
	static Scanner scanner = new Scanner(System.in);
	private int math, science, english;
	
	public Grade(int math, int science, int english) {
		this.math=math; this.science=science; this.english=english;
	}
	
	public double average() {
		return ((math+science+english)/3);
	}
	
	public static void main(String[] args) {
		System.out.print("수학,과학,영어 순으로 3개의 점수 입력>>");
		int math=scanner.nextInt();
		int science=scanner.nextInt();
		int english=scanner.nextInt();
		Grade me= new Grade(math,science,english);
		System.out.println("평균은"+me.average());
		scanner.close();
	}
}
