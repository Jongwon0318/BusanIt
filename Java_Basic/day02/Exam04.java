package day02;

public class Exam04 {
	//�������� 5�� ���� ���̸� ���Ͻÿ�
	//�������� ����*3.14
	public static void main(String[] args) {
	double r = 5;
	System.out.println("���� ����="+r*r*3.14);
	
	int a=10;
	float f;
	
	f=a;  // float = int ����ȯ(ĳ����) - �ڵ�����ȯ
	System.out.println("f="+f);
	
	float f1 = 10.5f;
	//a=f1; // a�� int��, f1�� float��, float���� �� ũ�Ƿ� ���� �� ����, ������ ����.
	
	a=(int)f1
			; // int=float, ǥ�����ϴ� �κ��� �߸� �� �ִ�. ���������� ����ȯ(ĳ����)
					 //����� ����ȯ
	System.out.println("a="+a); // ����� ����ȯ�� ����� ��������� 0.5�� �߷�����
	
	final double PI=3.14; // ������, final = ���(������ �ʴ� ��)�� �ǹ�
	double r1=10.5;
	double area = r1*r1*PI;
	System.out.println("������="+area);
		}
}