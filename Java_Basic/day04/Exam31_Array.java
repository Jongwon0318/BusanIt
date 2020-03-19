package day04;
import java.util.Scanner;

public class Exam31_Array {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 수를 입력하시겠습니까?");
		int cnt=sc.nextInt();
		int[] arr=new int[cnt];
		System.out.println("원하는 수를 입력하십시오.");
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			arr [i]=sc.nextInt();
		sum+=arr[i];
		} 
		System.out.println("저장된 수의 합계 : "+sum);
		for(int i=0; i<arr.length; i++)
		System.out.println("저장된 수 : "+arr[i]);
	}
}