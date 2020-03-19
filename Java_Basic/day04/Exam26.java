package day04;

public class Exam26 {
 public static void main(String[] args) {
	 for(int i=1; i<=9; i++) {
		 for(int j=3; j<=5; j++) {
			 System.out.print(j+"*"+i+"="+i*j+"\t");
		 }System.out.println();
	 }
 }
} //이중 for문에서는 안에있는 for문이 먼저 동작한다.