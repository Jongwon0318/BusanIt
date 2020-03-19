package review_ex;
import java.util.Scanner;

public class Exam23_1 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		{System.out.println("몇 개의 수를 입력하시겠습니까?");
		int cnt=sc.nextInt();
		int sum=0;
		int[] arr=new int[cnt];
		System.out.println(cnt+"개의 수를 입력하십시오.");
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}System.out.println("합계 : "+sum+"\n");
		for(int i=0; i<arr.length; i++) System.out.println(arr [i]);}
		{System.out.println("몇개의 수를 입력하시겠습니까?");
		int count=sc.nextInt();
		int hap=0;
		int[] arr=new int[count];
		System.out.println(count+"개의 수를 입력하세요.");
		for(int i=0; i<arr.length; i++) {
			arr[i]=sc.nextInt();
			hap+=arr[i];
		}System.out.println("입력한 수들의 합은 : "+hap);
		for(int i=0; i<arr.length; i++) System.out.println("나열한 "+i+"번째 수 : "+arr[i]);
		}
	}
}