package chap05;
import java.util.Scanner;
public class ShapeMain {
	
	public static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		ShapeManager sm= new ShapeManager();
		while(true) {
			sm.showMenu();
			int choice=ShapeMain.sc.nextInt();
			switch(choice) {
			case 1: //원입력 왜 지워도 될까?
			case 2: sm.inputData(choice); break; //사각형입력
			case 3: sm.viewData(); break;
			case 4: System.out.println("프로그램을 종료합니다.");
							System.exit(0);
			default : System.out.println("입력오류");
			}
		}
	}

}
