package review_ex;
import java.util.Scanner;

public class RSPwithComputer {
	public static void main(String[] args) {
		String[] computer= {"����","����","��"};
		Scanner sc=new Scanner(System.in);
		System.out.println("������������ �����մϴ�. �����Ͻ÷��� '�׸�'�� �Է����ּ���.");

		while(true) {
			int r =(int)(Math.random()*3);
			System.out.println("\n"+"���� ���� ��!!");
			System.out.print("�Է� : ");
			String player=sc.next();
			if(player.equals("�׸�")) {
				System.out.println("������������ �����մϴ�.");
				break;
			}
			if(computer[r].equals(player)) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"�����ϴ�.");
				continue;
			}else if(computer[r].equals("����") && player.equals("����")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"����� �̰���ϴ�.");
				continue;
			}else if(computer[r].equals("����") && player.equals("��")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"��ǻ�Ͱ� �̰���ϴ�.");
				continue;
			}else if(computer[r].equals("����") && player.equals("��")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"����� �̰���ϴ�.");
				continue;
			}else if(computer[r].equals("����") && player.equals("����")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"��ǻ�Ͱ� �̰���ϴ�.");
				continue;
			}else if(computer[r].equals("��") && player.equals("����")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"����� �̰���ϴ�.");
				continue;
			}else if(computer[r].equals("��") && player.equals("����")) {
				System.out.println("\n"+"��ǻ�� : "+computer[r]);
				System.out.println("\n"+"Player : "+player);
				System.out.println("\n"+"��ǻ�Ͱ� �̰���ϴ�.");
				continue;
			}
		}
	}
}
