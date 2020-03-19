package review_ex;
import java.util.Scanner;

public class Exam32 {
	public Exam32() {}
	public static int[] data= {10,5,90,100,250,30,77};
	static int searchNum=0;
	
	public static void max(int[] data) {
		int max=0;
		for(int i=0; i<data.length; i++) {
			for(int j= 0; j<i; j++) {
				if(data[i]>data[j]) {
					max=data[i];
				}else {
					max=data[j];
				}
			}
		}
		System.out.println("배열 내 최댓값 : "+max);
	}
	
	public static void sum(int[] data) {
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum+=data[i];
		}
		System.out.println("배열의 합 : "+sum);
	}
	
	public void search(int [] data, int searchNum) {
		this.data=data; this.searchNum=searchNum;
	}
	
	public void max() {

	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Exam32 a=new Exam32();
		Exam32.max(data);
		Exam32.sum(data);
		/*Exam32.maxPos(data);
		
		Exam32.avg(data);
		System.out.println("찾을 숫자를 입력하세요.");
		int searchNum=sc.nextInt();
		Exam32.search(data,searchNum);*/
	}
}
