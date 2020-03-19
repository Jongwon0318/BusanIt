package day02;
import java.util.Scanner;
/*
 * 시험 점수를 입력받고
 * 합격점수도 입력받아 시험점수가 합격점수 이상이면 합격
 * 그렇지 않으면 불합격 출력
 */
public class Exam08 {
	public static void main(String[] args) {
		System.out.println("시험 점수를 입력하고 엔터를 누르세요.");
				Scanner sc = new Scanner(System.in);
		int x = sc.nextInt(); 
		System.out.println("합격 점수를 입력하고 엔터를 누르세요.");
		int y = sc.nextInt(); 
			if(x<y) {
			System.out.print("불합격입니다. ");
		}else {
			System.out.print("합격입니다. ");
		}
			//시험점수가 3의 배수인지 아닌지 구분하라
			if(x%3==0) {
				System.out.println("시험 점수는 3의 배수입니다.");
			}else {
				System.out.println("시험 점수는 3의 배수가 아닙니다.");
			}
	}
}

 /*
package day02
 import java.util.Scanner;
 
 public class Exam08 {
 	public static void main(String[] args){
 		Scanner sc = new Scanner(System.in);
 		System.out.println("시험점수입력");
 		int score = sc.nextInt();
 		System.out.println("합격점수입력");
 		int cutline = sc.nextInt();
 			if(score>=cutline){
 			System.out.println("합격입니다")
 			}else{
 			System.out.println("불합격입니다")
 			}
 		}
 	}
*/