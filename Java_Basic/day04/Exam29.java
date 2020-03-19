package day04;

public class Exam29 {
	public static void main(String[] args) {

	//1~10합, 11~20합, ... 를 이중 for문으로 표현
		int sum=0;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10*i; j+=10) {
				sum+=j;
				System.out.println(j+"부터"+(j+9)+"까지의 합 : "+sum);
				sum=0;
			}
		System.out.println();
		}
	}
}
