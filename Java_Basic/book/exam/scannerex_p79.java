package book.exam;
import java.util.Scanner;
//�̸�,����,����,ü��,���ſ���
public class scannerex_p79 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���.");
		String name=sc.next();
		
		System.out.println("���ֵ��ø� �Է��ϼ���.");
		String city=sc.next();
		
		System.out.println("���̸� �Է��ϼ���.");
		int age=sc.nextInt();
		
		System.out.println("ü���� �Է��ϼ���.");
		double weight=sc.nextDouble();
		
		System.out.println("���ſ��θ� O �Ǵ� X�� �Է��ϼ���.");
		String marrige=sc.next();
		
		System.out.println("�̸� : "+name+"\n"+"���ֵ��� : "+city+"\n"
											+"���� : "+age+"��"+"\n"+"ü�� : "+weight+"kg"+"\n"
											+"���ſ��� : "+marrige+"\n");
	}
}
