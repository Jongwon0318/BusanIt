package review_ex;
import java.util.Scanner;

public class Exam11 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 	 	System.out.println("���������� �Է��ϼ���.");
	 	 	int kor=sc.nextInt();
	 	 	System.out.println("���������� �Է��ϼ���.");
	 	 	int math=sc.nextInt();
	 	 	System.out.println("���������� �Է��ϼ���.");
	 	 	int eng=sc.nextInt();

	 	 	int tot=kor+math+eng;
	 	 	System.out.println("���� : "+tot);
	 	 	int avg=tot/3;
	 	 	System.out.println("��� : "+avg);
	 	 	int a=avg/10;
	 	 		switch(a) {
	 	 		case 10:
	 	 		case 9: System.out.println("���� : A"); break;
	 	 		case 8: System.out.println("���� : B"); break;
	 	 		case 7: System.out.println("���� : C"); break;
	 	 		default: System.out.println("���� : F");
	 	 		}
 }
}
