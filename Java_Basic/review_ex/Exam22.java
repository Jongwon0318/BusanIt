package review_ex;

public class Exam22 {
	public static void main(String[] args) {
		byte n1=13; // 0 0 0 0 1 1 0 1 //13= 1+4+8 
		byte n2=7; // 0 0 0 0 0 1 1 1  //7=1+2+4
		int n3=n1&n2; // 0 0 0 0 0 1 0 1 = 5
		int n4=n1|n2; // 0 0 0 0 1 1 1 1=15
		int n5=n1^n2; // exclusively work, 0 0 0 0 1 0 1 0 = 10
				System.out.println("n3 : "+n3); //5
				System.out.println("n4 : "+n4); //15
				System.out.println("n5 : "+n5); //10
				System.out.println("~n5 : "+~n5); // 모르겠음!!
				System.out.println(n1>>1); // 0 0 0 0 0 1 1 0 = 6
				System.out.println(n1>>2); // 0 0 0 0 0 0 1 1 = 3
				System.out.println(n1<<1); // 0 0 0 1 1 0 1 0 = 2+8+16 = 26
	}
}
