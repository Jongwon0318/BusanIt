package day03;

public class Exam21 {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1; i<=10; i++) {
			if(i%2==1) sum+=i;
		}System.out.println("=========for��========="+"\n"+"1���� 10���� Ȧ���� �� : "+sum+"\n");
		
		int hap=0;
		for(int i=1; i<=10; i++) {
			if(i%2!=1) continue; //���ǿ� ���� ������ �ٽ� 11�� �ö󰣴�
			hap+=i;
		}System.out.println("=====for+continue;��====="+"\n"+"1���� 10���� Ȧ���� �� : "+hap+"\n");
		
		int mak=0;
		int i=1;
		while(true) {
			if(i%2==1) mak+=i;
			i++;
			if(i==10) break;
		}System.out.println("=====while(true)��====="+"\n"+"1���� 10���� Ȧ���� �� : "+mak+"\n"); 
	}//main
}//class