package day01;

public class Exam02 {
	public static void main(String[] args) {
		System.out.println("2+5");
		System.out.println(2+5);
		System.out.println("2+5="+2+5);
		System.out.println("2+5="+(2+5));
		
		int num1; //����
		num1 = 50; //�Ҵ�(�ʱⰪ�ο�)
		System.out.println(num1);
		int num2 = 70; // ����� �Ҵ��� ���� �� ��
		System.out.println(num2);
		//num1+num2=120 ǥ��
		System.out.println("num1+num2="+(num1+num2));
		//50+70=120 ǥ��
		System.out.println("50+70="+(50+70)); //num1, num2�� �ٲ���� �ֱ� ������ �������� �ƴ� ���������� ǥ���ؾ��Ѵ�. Ʋ�� ��
		System.out.println(num1+"+"+num2+"="+(50+70)+"\n"+"\n");
	
/*
 * a��� ������ 10�� �Ҵ�
 * b��� ������ 20�� �Ҵ�
 * a+b=30
 * a����b=���̳ʽ�10
 * a*b=200
 * a/b=1/2
 */
/* Ʋ����
			int a = 10;
			int b = 20;
			System.out.println("a+b="+(a+b));
			System.out.println("a-b="+(a-b));
			System.out.println("a*b="+(a*b));
			System.out.println("a/b="+(a/b)); */ 
	int a=20; // int-> 4����Ʈ(1����Ʈ�� 8��Ʈ, 4����Ʈ�� 32��Ʈ)
	int b=10;
		{
		System.out.println("a=20");
		System.out.println("b=10");
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b));
		System.out.println(a+"%"+b+"="+(a%b));
		}
	//int c = 1000000000000;
	long c= 1000000000000L; //8����Ʈ
	
	//3.25�� ǥ��(�Ҽ���)
	float f=3.25F; //4����Ʈ
	double g=3.25; //8����Ʈ
	
	//���� �ϳ�(2����Ʈ) ���� �ϳ��� ǥ���Ҷ��� �ݵ�� ' �� ' �� ���.(�ѵ���ǥ)
	//char ch="a"; // �����߻�
	char ch='A';
	}
}

