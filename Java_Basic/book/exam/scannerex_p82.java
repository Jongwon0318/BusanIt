package book.exam;
import java.util.Scanner;
//�ʴ����� ������ �Է¹ް�, ��ð�, ���,�������� ����ϴ� ���α׷��� �ۼ��϶�.
public class scannerex_p82 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�ʴ����� ���� �Է��ϼ���.");
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
		System.out.println("�Է��Ͻ� "+second+"�ʴ� "+hour+"�ð�"+min+"��"+sec+"�� �Դϴ�.");
	}
}