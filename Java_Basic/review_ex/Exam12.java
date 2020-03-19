package review_ex;

public class Exam12 {
	public static void main(String[] args) {
		int n1=5;
		int n2=++n1;
			System.out.println("n1: "+n1); //6
			System.out.println("n2: "+n2+"\n"); //6
		int n3=n1++;
			System.out.println("n1: "+n1);  //7
			System.out.println("n3: "+n3+"\n"); //6
		
		int a=50;
		int b=3;
		int c;
		int d;
		a++; //51
		++b; //4
		c=a++ + ++b; //51 + 5 = 56, a--->52
			System.out.println("a :"+a); //52
			System.out.println("b :"+b); //5
			System.out.println("c :"+c); //56
		d=++a + ++b; //53+6=59
			System.out.println("d :"+d); //59
	}
}