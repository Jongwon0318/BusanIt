package day03;
import java.util.Scanner;
//��Է¹������𸣴ϱ� for���� �ָ��ϴ�.--->while���� ����.
public class Exam20 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
				
		System.out.println("����� �Է��ϼ���. -1�� �Է��ϸ� �� �Է��� ����˴ϴ�.");
		int sum=0;
		int cnt=0; //cnt = �Է��� ���� ����
		while(true) { // while(true){} : ���ѷ���, {}�ȿ� ������ ����� �־ ���ǿ� ������ ������ش�.
			int num=sc.nextInt();
			if(num== -1) break; //�ݺ����� �׸��δ°�, break�� continue�� ���� ������ �ʿ䰡 ����.
			
			cnt++; //wow
			sum+=num; //�հ�
			int avg=sum/cnt; //cnt = �Է��� ���� ����
			
		}System.out.println("�հ� : "+sum+"\t"+"��� : "+sum/cnt);
	}
}