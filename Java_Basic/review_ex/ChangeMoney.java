package review_ex;
import java.util.Scanner;
public class ChangeMoney {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�ݾ��� �Է��ϼ���.");
		int money=sc.nextInt();
		System.out.println("�Է��Ͻ� �ݾ� : "+money+"��");
		//50000,10000,5000,1000,500,100,50,10,1
		int[] moneyArr= {50000,10000,5000,1000,500,100,50,10,1};
		int[] cnt=new int[9];
		for(int i=0; i<moneyArr.length; i++) {
			if(money/moneyArr[i]!=0) {
				cnt[i]=money/moneyArr[i];
				money-=moneyArr[i]*cnt[i];
				System.out.println(moneyArr[i]+"�� : "+cnt[i]);
			}
		}
	}
}