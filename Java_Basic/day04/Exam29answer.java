package day04;

public class Exam29answer {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1; i<=100 ; i+=10) { //1     11                     21
			for(int j=i; j<(i+10); j++) { //1부터 10까지, 11부터 20까지, 21부터 30까지
				sum+=j;
			}
			System.out.println(i+"부터 "+(i+9)+"까지의 합은 : "+sum);
			sum=0;
		}
	}
}