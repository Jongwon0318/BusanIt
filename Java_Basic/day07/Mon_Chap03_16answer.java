package day07;
import java.util.Scanner;

public class Mon_Chap03_16answer {
	public static void main(String[] args) {
		String com[]= {"����","����","��"};
		Scanner scanner=new Scanner(System.in);
		System.out.println("��ǻ�Ϳ� ���������� ������ �մϴ�.");
		while(true) {
			System.out.print("���� ���� ��!>>");
			String a=scanner.next(); //���ڿ� �б�
			int r=(int)(Math.random()*3); //���� ���ϱ� (0�Ǵ� 1�Ǵ� 2)
			String str=com[r];
			System.out.println("����� : "+a+", ��ǻ�� : "+str);
			
			if(a.equals("����")) {
				if(str.equals("����")) {
					System.out.println("�����ϴ�.");
				}else if(str.equals("����")) {
					System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				}else {
					System.out.println("����ڰ� �̰���ϴ�.");
				}
			}
			
			if(a.equals("����")) {
				if(str.equals("����")) {
					System.out.println("�����ϴ�.");
				}else if(str.equals("��")) {
					System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				}else {
					System.out.println("����ڰ� �̰���ϴ�.");
				}
			}
			
			if(a.equals("��")) {
				if(str.equals("��")) {
					System.out.println("�����ϴ�.");
				}else if(str.equals("����")) {
					System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
				}else {
					System.out.println("����ڰ� �̰���ϴ�.");
				}
			}
			
			if(a.equals("�׸�")) {
				System.out.print("������ �����մϴ�...");
				break; //while�� ���, ���α׷� ����
			}//if ����:com[0]
		}//while
	}
}
