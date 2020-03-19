package day06_object;

public class Baby { //반드시 클래스가 main을 가지고 있는 것은 아니다.
	String name;
	int age; // 변수들은 객체마다 가지는 것.
	public void smile() {
		System.out.println("웃는다");
	}
	public void cry()	{
		System.out.println("운다");
	}
	public static void main(String[] args) {
		Baby b1 = new Baby(); //m
		//System.out.println(b1.smile()); 잘못된것.
		b1.smile(); //7
		b1.age=10; //5
		System.out.println(b1.age); //m
		
		Baby b2 = new Baby(); //m`
		System.out.println(b2.age); //5`
		System.out.println("b1 : "+b1); //m
		System.out.println("b2 : "+b2); //m`
		
		Baby b3 = new Baby(); //m``
		b3.name="홍길동"; //4
		b3.age=2; //5
		System.out.println("이름 : "+b3.name+"\n"+"나이 : "+b3.age);
		b3.cry();
		
		Baby b4; //선언
		// Baby b4 = new Baby(); //Baby b4; 만 치면 오류 , 선언과 생성을 동시에
		b4 = new Baby(); //생성
		b4.name="이순신";
	}
}