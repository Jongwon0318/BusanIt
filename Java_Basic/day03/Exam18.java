package day03;
import java.util.Scanner;
//2
public class Exam18 {
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("학생 수를 입력하시오.");
	 int num=sc.nextInt();
	 System.out.println("한줄에 앉을 학생의 수를 입력하시오.");
	 int line=sc.nextInt();
	 System.out.println("\n"+"좌석배치도"+"\n");
	 for(int i=1; i<=num; i++) {
		System.out.print(i+"\t");
		if(i%line==0) System.out.print("\n");
		
	 }
	 /*int row=num/line;
	 if(num%line!=0)  //if문에 걸려있는 것이 한줄이라면 {}를 지워도 된다.
		 row=row+1;
		 */
	 //삼항연산자(조건연산자) ---> 변수 = 조건 ?  참인조건 : 거짓인 조건 ;
	  //row= 학생수가 한줄학생수로 나누어떨어지는가 ?  나누어떨어진다 : 나누어떨어지지않는다. ;
	 int  row=(num/line==0)? num/line: num/line+1;
	 System.out.println("\n"+"줄의 수 : "+row);
 }
}