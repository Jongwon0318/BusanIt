package review_ex;
import java.util.Scanner;

public class Exam23 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��� ���� �Է��Ͻðڽ��ϱ�?");
		int cnt=sc.nextInt();
		int sum=0;
		int[] arr=new int[cnt];
		System.out.println(cnt+"���� ���� �Է��Ͻʽÿ�.");
		for(int i=0; i<arr.length; i++) {
			arr [i]=sc.nextInt();
			sum+=arr[i];
		}System.out.println("\n"+"�Է¹��� ������ �հ�� : "+sum+"\n");
		for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
	}
}