package day02;
import java.util.Scanner;
/*
 * ���� ������ �Է¹ް�
 * �հ������� �Է¹޾� ���������� �հ����� �̻��̸� �հ�
 * �׷��� ������ ���հ� ���
 */
public class Exam08 {
	public static void main(String[] args) {
		System.out.println("���� ������ �Է��ϰ� ���͸� ��������.");
				Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); 
		System.out.println("�հ� ������ �Է��ϰ� ���͸� ��������.");
		int y = sc.nextInt(); 
			if(x<y) {
			System.out.print("���հ��Դϴ�. ");
		}else {
			System.out.print("�հ��Դϴ�. ");
		}
			//���������� 3�� ������� �ƴ��� �����϶�
			if(x%3==0) {
				System.out.println("���� ������ 3�� ����Դϴ�.");
			}else {
				System.out.println("���� ������ 3�� ����� �ƴմϴ�.");
			}
	}
}

 /*
package day02
 import java.util.Scanner;
 
 public class Exam08 {
 	public static void main(String[] args){
 		Scanner sc = new Scanner(System.in);
 		System.out.println("���������Է�");
 		int score = sc.nextInt();
 		System.out.println("�հ������Է�");
 		int cutline = sc.nextInt();
 			if(score>=cutline){
 			System.out.println("�հ��Դϴ�")
 			}else{
 			System.out.println("���հ��Դϴ�")
 			}
 		}
 	}
*/