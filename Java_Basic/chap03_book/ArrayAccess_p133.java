package chap03_book;
import java.util.Scanner;

public class ArrayAccess_p133 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[5];
		int max=0;
		System.out.println("��� 5���� �Է��ϼ���.");
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>max) max=arr[i];
		}
		System.out.println("���� ū ���� : "+max);
	}
}