package review_ex;
import java.util.Scanner;

public class Exam23 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("몇개의 수를 입력하시겠습니까?");
		int cnt=sc.nextInt();
		int sum=0;
		int[] arr=new int[cnt];
		System.out.println(cnt+"개의 수를 입력하십시오.");
		for(int i=0; i<arr.length; i++) {
			arr [i]=sc.nextInt();
			sum+=arr[i];
		}System.out.println("\n"+"입력받은 수들의 합계는 : "+sum+"\n");
		for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
	}
}