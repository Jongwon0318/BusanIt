package day02;
import java.util.Scanner;
//���� �ϳ��� �Է¹޾� �� ���ڰ� ¦������ Ȧ������ �����Ͻÿ�.
public class Exam07 {
	public static void main(String[] args){
		
		Scanner scn = new Scanner (System.in);
		System.out.print("���ڸ� �Է��ϼ���");
		int x = scn.nextInt(); 
		System.out.print("����  " +x+" : ");
		if(x%2==0){
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		}
}