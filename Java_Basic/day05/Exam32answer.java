package day05;
import java.util.Scanner;

public class Exam32answer {
	public static void main(String[] args) {
		int [ ] data = {10,5,90,100,250,30,77};
		Scanner sc=new Scanner(System.in);
		System.out.println("ã�� ���ڸ� �Է��ϼ���.");
		int search=sc.nextInt();
		boolean flag=false;
		for(int i=0; i<data.length; i++) {
			if(search==data[i]) {
				System.out.println(data[i]+" : "+i+"��°�� �ֽ��ϴ�.");
				flag=true;
			}
		}
		if(flag==false) System.out.println("ã�� �� : "+search+" �����ϴ�.");
	}
}