package day03;
import java.util.Scanner;

public class Exam16 {
	public static void main(String[] args) {

		//1
		for(int i=1; i<=9; i++) {
			System.out.print(i+"+");
		}
		for(int i=10; i<11; i++) {
			System.out.print(i+"=");
		}
		int sum=0;
		for(int i=1; i<=10; i++) {
			sum=sum+i;
		}System.out.println(sum);
		System.out.print("\n");
		
	    //2
		for(int i=1; i<=9; i++){
		int gg=2*i;
		System.out.println("2*"+i+"="+ gg+"\t");
		}
		System.out.print("\n");
				    
				
		//3
		Scanner sc=new Scanner(System.in);
		System.out.println("������ ����� ����ұ��? ���ڸ� �Է��ϼ���.");
		int dan=sc.nextInt();
			for(int i=1; i<=9; i++) {
			int gugudan=dan*i;
			System.out.println(dan+"*"+i+"="+gugudan);
			}
			System.out.print("\n");
							
		//4
		int hap=0;
			for(int i=1; i<=10; i++) {
				if(i%2==0) {
					hap=hap+i;
				}
			}System.out.println("1���� 10������ �� �� ¦���� �� : "+hap);
			System.out.print("\n");
									
		//5
		int dap=0;
			for(int i=2; i<=10; i+=2) {
			dap=dap+i; // dap+=i�� �������̴�.
			}System.out.println("1���� 10������ �� �� ¦���� �� : "+dap);
	}
}