package day07;
import java.util.Scanner;

public class Mon_Chap03_16answer {
	public static void main(String[] args) {
		String com[]= {"가위","바위","보"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("컴퓨터와 가위바위보 게임을 합니다.");
		while(true) {
			System.out.print("가위 바위 보!>>");
			String a=scanner.next(); //문자열 읽기
			int r=(int)(Math.random()*3); //난수 구하기 (0또는 1또는 2)
			String str=com[r];
			System.out.println("사용자 : "+a+", 컴퓨터 : "+str);
			
			if(a.equals("가위")) {
				if(str.equals("가위")) {
					System.out.println("비겼습니다.");
				}else if(str.equals("바위")) {
					System.out.println("컴퓨터가 이겼습니다.");
				}else {
					System.out.println("사용자가 이겼습니다.");
				}
			}
			
			if(a.equals("바위")) {
				if(str.equals("바위")) {
					System.out.println("비겼습니다.");
				}else if(str.equals("보")) {
					System.out.println("컴퓨터가 이겼습니다.");
				}else {
					System.out.println("사용자가 이겼습니다.");
				}
			}
			
			if(a.equals("보")) {
				if(str.equals("보")) {
					System.out.println("비겼습니다.");
				}else if(str.equals("가위")) {
					System.out.println("컴퓨터가 이겼습니다.");
				}else {
					System.out.println("사용자가 이겼습니다.");
				}
			}
			
			if(a.equals("그만")) {
				System.out.print("게임을 종료합니다...");
				break; //while문 벗어남, 프로그램 종료
			}//if 가위:com[0]
		}//while
	}
}
