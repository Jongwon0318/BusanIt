package chap03_book;
import java.util.Scanner;

public class ArrayAccess_p135 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[5];
		int sum=0;
		System.out.println("정수를 5개 입력하세요.");
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		System.out.println("입력하신 정수들의 평균값은 : "+sum/arr.length);
	}
}