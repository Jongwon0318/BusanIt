package book.exam;
import java.util.Scanner;

public class scannerex_p82_answer {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�ʸ� �Է��ϼ���.");
		int sec=sc.nextInt();
		int hour=sec/3600;
		int min=sec%3600/60;
		int second=sec%3600%60;
		System.out.println("�Է��Ͻ� "+sec+"�ʴ� "+hour+"�ð�"+min+"��"+second+"�� �Դϴ�.");		
	}
}