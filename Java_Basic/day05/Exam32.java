package day05;
import java.util.Scanner;

public class Exam32 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1; i<6; i++) {
			for(int j=1; j<=i; j++) 	System.out.print(j); //�������� ��������.
			System.out.println();
		}
	
		int [ ] data = {10,5,90,100,250,30,77};
		int max=data[0]; //���ο� ������ ����ϰ�������� ������ �����ض�!
		int maxPos=0;
		int sum=0;
		for(int i=0; i<data.length; i++) {
			if(max<data[i]) {
				max=data[i]; // if(max<data[i]) max=data[i]
				maxPos=i+1;
			}
			sum+=data[i];
		}//max=data[4]=250;
		System.out.println("\n"+"�ִ� : "+max+"\n"
											+"�ִ��� ��ġ : "+maxPos+"��°"+"\n"
											+"�迭�� �հ� : "+sum+"\n"
											+"�迭�� ��� : "+(float)sum/data.length+"\n"//(   )�� ���� ���� ĳ����(����ȯ)��Ű�� ��ɾ�
											+"ã�� ���ڸ� �Է��ϼ���.");
		int find=sc.nextInt();
		int findPos=data.length+1;
		for(int i=0; i<data.length; i++) {
			if (find==data[i]) 	findPos=i;
		}
		if(findPos<=data.length)	System.out.println(find+"���� �迭�� "+(findPos+1)+"��°�� �ֽ��ϴ�.");
		if(findPos==data.length+1) System.out.println("ã�� �� "+find+" : �迭 ���� �������� ����.");
	} 																	
}