package day02;

public class Exam04 {
	//반지름이 5인 원의 넓이를 구하시오
	//반지름의 제곱*3.14
	public static void main(String[] args) {
	double r = 5;
	System.out.println("원의 넓이="+r*r*3.14);
	
	int a=10;
	float f;
	
	f=a;  // float = int 형변환(캐스팅) - 자동형변환
	System.out.println("f="+f);
	
	float f1 = 10.5f;
	//a=f1; // a는 int형, f1은 float형, float형이 더 크므로 담을 수 없음, 오류가 난다.
	
	a=(int)f1
			; // int=float, 표현못하는 부분은 잘릴 수 있다. 마찬가지로 형변환(캐스팅)
					 //명시적 형변환
	System.out.println("a="+a); // 명시적 형변환의 결과로 결과값에서 0.5가 잘려버림
	
	final double PI=3.14; // 원주율, final = 상수(변하지 않는 수)를 의미
	double r1=10.5;
	double area = r1*r1*PI;
	System.out.println("원넓이="+area);
		}
}