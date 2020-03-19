package day02;
// 중요~~~~~~
public class Exam12 {
	public static void main(String[] args) {
		int n1=5;
		int n2=++n1; //전위 : 먼저 수행하고 대입
		System.out.println("n1: "+n1);  //6
		System.out.println("n2: "+n2);  //6
		System.out.println("===== ");
		int n3=n1++; // 후위 : 먼저 대입하고 나중에 수행하라
		System.out.println("n1: "+n1);	 //7
		System.out.println("n3: "+n3);	 //6
		
		int num1 = 7;
		int num2 = --num1; //num2=6 num1=6
		int num3 = num1--; //num3=6 num1=5
		System.out.println("num1: "+num1); // ?? =5
		System.out.println("num2: "+num2); // ?? =6
		System.out.println("num3: "+num3); //  ?? =6
		
		int a=50 , b= 3;
		int c;
		int d;
		
		a++;  //a=50----->a=51
		++b;  //4
		c=a++ + ++b;  //a=51 b=5 c=56-------->a=52
		d=++a + ++b;
		
		System.out.println("a : "+a); // ?? 52
		System.out.println("b : "+b); // ?? 5
		System.out.println("c : "+c); // ??  56
		System.out.println("d : "+d);
		
		int aa=10, bb=3;
		int cc;
		int dd;
		
		--aa; // aa= 9
		bb++; // bb = 3-> 4
		cc= --aa + ++bb; // aa=8, bb=5, cc=13 
											//dd=aa-- + ++bb;
		System.out.println("aa : "+aa); // 8
		System.out.println("bb : "+bb); // 5
		System.out.println("cc : "+cc); // 13 
											//System.out.println("dd : "+dd);
	}
}