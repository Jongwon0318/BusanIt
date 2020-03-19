package review_ex;
import java.util.Scanner;

public class Exam11 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 	 	System.out.println("국어점수를 입력하세요.");
	 	 	int kor=sc.nextInt();
	 	 	System.out.println("수학점수를 입력하세요.");
	 	 	int math=sc.nextInt();
	 	 	System.out.println("영어점수를 입력하세요.");
	 	 	int eng=sc.nextInt();

	 	 	int tot=kor+math+eng;
	 	 	System.out.println("총점 : "+tot);
	 	 	int avg=tot/3;
	 	 	System.out.println("평균 : "+avg);
	 	 	int a=avg/10;
	 	 		switch(a) {
	 	 		case 10:
	 	 		case 9: System.out.println("학점 : A"); break;
	 	 		case 8: System.out.println("학점 : B"); break;
	 	 		case 7: System.out.println("학점 : C"); break;
	 	 		default: System.out.println("학점 : F");
	 	 		}
 }
}
