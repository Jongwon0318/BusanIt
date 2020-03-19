package book.exam;
import java.util.Scanner;
//초단위의 정수를 입력받고, 몇시간, 몇분,몇초인지 출력하는 프로그램을 작성하라.
public class scannerex_p82 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("초단위의 수를 입력하세요.");
		int sec=sc.nextInt();
		int second=sec;
		int hour=0;
		int min=0;
		if(sec>=3600) {
			sec-=3600;
			hour++;
		}else{
			sec-=60;
			min++;
		}
		System.out.println("입력하신 "+second+"초는 "+hour+"시간"+min+"분"+sec+"초 입니다.");
	}
}