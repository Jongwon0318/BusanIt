package day02;
import java.util.Scanner;

//���̸� �Է¹޾� ���̰� 20�̻��̸� ���尡��
//15�� �̻� 20 �̸��̸� �θ�԰� ��������
//15�� �̸��̸� ���� �Ұ���
public class Exam07_1 {
	public static void main(String[] args) {
		System.out.print("���̸� �Է��Ͻÿ�  ");
		Scanner sc= new Scanner(System.in); //����
			int age=sc.nextInt();
			System.out.print("\n");
			if(age<15) {
				System.out.print("���� �Ұ�");
			}else if(age>=15 && age < 20){
				System.out.print("�θ�԰� ��������");
			}else{
				System.out.print("���� ����");
			}
	}
}