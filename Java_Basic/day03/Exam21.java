package day03;

public class Exam21 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1; i<=10; i++) {
			if(i%2==1) sum+=i;
		}System.out.println("=========for절========="+"\n"+"1부터 10까지 홀수의 합 : "+sum+"\n");
		
		int hap=0;
		for(int i=1; i<=10; i++) {
			if(i%2!=1) continue; //조건에 맞지 않으면 다시 11로 올라간다
			hap+=i;
		}System.out.println("=====for+continue;절====="+"\n"+"1부터 10까지 홀수의 합 : "+hap+"\n");
		
		int mak=0;
		int i=1;
		while(true) {
			if(i%2==1) mak+=i;
			i++;
			if(i==10) break;
		}System.out.println("=====while(true)절====="+"\n"+"1부터 10까지 홀수의 합 : "+mak+"\n"); 
	}//main
}//class