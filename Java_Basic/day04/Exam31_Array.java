package day04;
import java.util.Scanner;

public class Exam31_Array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("��� ���� �Է��Ͻðڽ��ϱ�?");
		int cnt=sc.nextInt();
		int[] arr=new int[cnt];
		System.out.println("���ϴ� ���� �Է��Ͻʽÿ�.");
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			arr [i]=sc.nextInt();
		sum+=arr[i];
		} 
		System.out.println("����� ���� �հ� : "+sum);
		for(int i=0; i<arr.length; i++)
		System.out.println("����� �� : "+arr[i]);
	}
}