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
			case 1: //���Է� �� ������ �ɱ�?
			case 2: sm.inputData(choice); break; //�簢���Է�
			case 3: sm.viewData(); break;
			case 4: System.out.println("���α׷��� �����մϴ�.");
							System.exit(0);
			default : System.out.println("�Է¿���");
			}
		}
	}

}
