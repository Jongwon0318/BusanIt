package day02;
import java.util.Scanner;

/*
 * ��������/ ��������/ ���������� �Է¹޾�
 * ������ ����� ���Ͻÿ�
 * ��� 90�̻� a����/ 80�̻� B����/ 70�̻� C����
 * ������ F����
 * if / switch
 */
public class Exam11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				System.out.println("���������� �Է��Ͻʽÿ�.");
			int a = sc.nextInt();
				System.out.println("���������� �Է��Ͻʽÿ�.");
			int b = sc.nextInt();
				System.out.println("���������� �Է��Ͻʽÿ�.");
			int c = sc.nextInt();
				System.out.print("�������� : "+a+", ");
				System.out.print("�������� : "+b+", ");
				System.out.println("�������� : "+c);
				System.out.println("�� ���� : "+(a+b+c));
				System.out.println("������� : "+((a+b+c)/3)+"\n");
				//String grade=""�� ���·� ǥ������ // \t : �Ǹ�ŭ ���� ��
				double d = (a+b+c)/3;
				System.out.println("1) if���� �̿��� �������");			
							if(d >=90){
								System.out.println("���� : "+"A"+"\n");
							}else if (d>=80) {
								System.out.println("���� : "+"B"+"\n");
							}else if (d>=70) {
								System.out.println("���� : "+"C"+"\n");
							}else {
								System.out.println("���� : "+"F"+"\n");
							}
				System.out.println("2) Switch���� �̿��� �������");		
				int e =(((a+b+c)/3)/10) ;
				switch(e) {
				    case 10:System.out.println("���� : "+"A"); break; // ���� �Ƚᵵ ��
					case 9:System.out.println("���� : "+"A"); break;
					case 8:System.out.println("���� : "+"B"); break;
					case 7:System.out.println("���� : "+"C"); break;
					default:System.out.println("���� : "+"F");
			}
				if(((a+b+c)/3)%2!=0) {
					System.out.println("Ȧ��");
				}else {
					System.out.println("¦��");
				}
	}
}
// kor, math, eng, tot, avg, grade�� ���� �� �����ϰ� �����غ���. 
// System.out.println("���� :"+"\t"+tot+"\n"+"��� :"+"\t"+avg+"\n"+"���� :"+"\t"+grade);
/*                                                    "\t ��� :"
*		switch(avg/10){
*	case 10 :                                         ---------> break�� �����ʾƵ� �ְ������� A�̹Ƿ� �����´�.
*  case 9 : grade = "A" ; break;
*	case 8 : grade = "B"; break; 
*  case 7 : grade = "C"; break;
*  default : grade = "F"
*}
*/