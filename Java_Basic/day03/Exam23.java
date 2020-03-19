package day03;
import java.util.Scanner;

public class Exam23 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 수를 입력하시겠습니까?");
		int cnt=sc.nextInt();
		int sum=0; // "배열"?? int형을 여러개 담을 수 있는 구조를 만들겠다 = 배열 arr[]
		int[] arr=new int[cnt]; // arr은 항상 0부터 시작한다.
		System.out.println("수 "+cnt+"개를 입력하십시오.");
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}System.out.println("합계 : "+sum+"\n");
		for(int i=0; i<arr.length; i++) 
		System.out.println(arr[i]);
	}
}