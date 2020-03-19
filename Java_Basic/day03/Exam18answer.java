package day03;
import java.util.Scanner;

public class Exam18answer {
 public static void main(String[] args) {

	 //1
	 int hap=0;
	 for(int i=1; i<=100; i++) {
		 hap+=i;
		 if(i%10==0) {
			 System.out.println((i-9)+"부터"+i+"까지의 합 : "+hap);
			 hap=0;   //wow
		 }
	 }
	 
	 //2
	 Scanner sc=new Scanner(System.in);
	 System.out.println("총 인원 수 : ");
	 	int tot=sc.nextInt();
	 System.out.println("한 줄에 몇명 앉을까요? : ");
	 	int line=sc.nextInt();
	 	for(int i=1; i<tot; i++){
		 System.out.print(i+"\t");
		  if(i%line==0) {
			 System.out.println();
		  }
	    }
 }
}