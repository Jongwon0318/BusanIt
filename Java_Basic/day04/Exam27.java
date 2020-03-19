package day04;

public class Exam27 {
	public static void main(String[] args) {
		for(int i=7; i>=1; i--) {
			for(int j=i; j>=1; j--) { //for(int j=1; j<-i; j++)
				System.out.print("*");
			}
			System.out.print("\t"+i);
			System.out.println();	
		}
		for(char i='i'; i>='a'; i-=2) {
			for(char j='a'; j<=i; j++) {
			System.out.print(j);
			}
		System.out.println();
		}		
	}
}