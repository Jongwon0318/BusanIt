package day01;

public class Exam02 {
	public static void main(String[] args) {
		System.out.println("2+5");
		System.out.println(2+5);
		System.out.println("2+5="+2+5);
		System.out.println("2+5="+(2+5));
		
		int num1; //선언
		num1 = 50; //할당(초기값부여)
		System.out.println(num1);
		int num2 = 70; // 선언과 할당을 같이 한 것
		System.out.println(num2);
		//num1+num2=120 표현
		System.out.println("num1+num2="+(num1+num2));
		//50+70=120 표현
		System.out.println("50+70="+(50+70)); //num1, num2는 바뀔수도 있기 때문에 정수값이 아닌 변수값으로 표현해야한다. 틀린 것
		System.out.println(num1+"+"+num2+"="+(50+70)+"\n"+"\n");
	
/*
 * a라는 변수에 10을 할당
 * b라는 변수에 20을 할당
 * a+b=30
 * a빼기b=마이너스10
 * a*b=200
 * a/b=1/2
 */
/* 틀린것
			int a = 10;
			int b = 20;
			System.out.println("a+b="+(a+b));
			System.out.println("a-b="+(a-b));
			System.out.println("a*b="+(a*b));
			System.out.println("a/b="+(a/b)); */ 
	int a=20; // int-> 4바이트(1바이트는 8비트, 4바이트는 32비트)
	int b=10;
		{
		System.out.println("a=20");
		System.out.println("b=10");
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b));
		System.out.println(a+"%"+b+"="+(a%b));
		}
	//int c = 1000000000000;
	long c= 1000000000000L; //8바이트
	
	//3.25의 표현(소숫점)
	float f=3.25F; //4바이트
	double g=3.25; //8바이트
	
	//문자 하나(2바이트) 문자 하나를 표현할때는 반드시 ' 과 ' 를 사용.(겉따옴표)
	//char ch="a"; // 오류발생
	char ch='A';
	}
}

