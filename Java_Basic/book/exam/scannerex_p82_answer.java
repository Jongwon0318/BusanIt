package book.exam;
import java.util.Scanner;

public class scannerex_p82_answer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("초를 입력하세요.");
		int sec=sc.nextInt();
		int hour=sec/3600;
		int min=sec%3600/60;
		int second=sec%3600%60;
		System.out.println("입력하신 "+sec+"초는 "+hour+"시간"+min+"분"+second+"초 입니다.");		
	}
}