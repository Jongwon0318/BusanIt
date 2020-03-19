package day02;
import java.util.Scanner;

/*
 * 국어점수/ 수학점수/ 영어점수를 입력받아
 * 총점과 평균을 구하시오
 * 평균 90이상 a학점/ 80이상 B학점/ 70이상 C학점
 * 나머지 F학점
 * if / switch
 */
public class Exam11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				System.out.println("국어점수를 입력하십시오.");
			int a = sc.nextInt();
				System.out.println("수학점수를 입력하십시오.");
			int b = sc.nextInt();
				System.out.println("영어점수를 입력하십시오.");
			int c = sc.nextInt();
				System.out.print("국어점수 : "+a+", ");
				System.out.print("수학점수 : "+b+", ");
				System.out.println("영어점수 : "+c);
				System.out.println("총 점수 : "+(a+b+c));
				System.out.println("평균점수 : "+((a+b+c)/3)+"\n");
				//String grade=""의 형태로 표현가능 // \t : 탭만큼 띄우는 것
				double d = (a+b+c)/3;
				System.out.println("1) if절을 이용한 학점계산");			
							if(d >=90){
								System.out.println("학점 : "+"A"+"\n");
							}else if (d>=80) {
								System.out.println("학점 : "+"B"+"\n");
							}else if (d>=70) {
								System.out.println("학점 : "+"C"+"\n");
							}else {
								System.out.println("학점 : "+"F"+"\n");
							}
				System.out.println("2) Switch절을 이용한 학점계산");		
				int e =(((a+b+c)/3)/10) ;
				switch(e) {
				    case 10:System.out.println("학점 : "+"A"); break; // 굳이 안써도 됨
					case 9:System.out.println("학점 : "+"A"); break;
					case 8:System.out.println("학점 : "+"B"); break;
					case 7:System.out.println("학점 : "+"C"); break;
					default:System.out.println("학점 : "+"F");
			}
				if(((a+b+c)/3)%2!=0) {
					System.out.println("홀수");
				}else {
					System.out.println("짝수");
				}
	}
}
// kor, math, eng, tot, avg, grade로 놓고 식 간략하게 정리해보기. 
// System.out.println("총점 :"+"\t"+tot+"\n"+"평균 :"+"\t"+avg+"\n"+"학점 :"+"\t"+grade);
/*                                                    "\t 평균 :"
*		switch(avg/10){
*	case 10 :                                         ---------> break를 걸지않아도 최고학점이 A이므로 내려온다.
*  case 9 : grade = "A" ; break;
*	case 8 : grade = "B"; break; 
*  case 7 : grade = "C"; break;
*  default : grade = "F"
*}
*/