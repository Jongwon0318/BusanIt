package chap05_book;
import java.util.Scanner;

public class StackApp{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�� ���� ���� ������ ũ�� �Է� >>");
		int n=sc.nextInt();
		StringStack ss=new StringStack(n);
		
		while(true) {
			System.out.print("���ڿ� �Է� >> ");
			String str=sc.next();
			if(str.equals("exit")) break;
			boolean flag = ss.push(str);
			if(flag==false) {
				System.out.println("������ �� ���� Ǫ�� �Ұ�");
			}
		}
		System.out.println("���ÿ� ����� ��� ���ڿ� �� : ");
		for(int i=0; i<ss.length(); i++) {
			System.out.println(ss.pop()+"\t");
		}
		
		sc.close();
	}

}
