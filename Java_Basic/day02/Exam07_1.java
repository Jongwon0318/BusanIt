package day02;
import java.util.Scanner;

//나이를 입력받아 나이가 20이상이면 입장가능
//15세 이상 20 미만이면 부모님과 동반입장
//15세 미만이면 입장 불가능
public class Exam07_1 {
	public static void main(String[] args) {
		System.out.print("나이를 입력하시오  ");
		Scanner sc= new Scanner(System.in); //선언
			int age=sc.nextInt();
			System.out.print("\n");
			if(age<15) {
				System.out.print("입장 불가");
			}else if(age>=15 && age < 20){
				System.out.print("부모님과 동반입장");
			}else{
				System.out.print("입장 가능");
			}
	}
}