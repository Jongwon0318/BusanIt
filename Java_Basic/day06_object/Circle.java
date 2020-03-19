package day06_object;

public class Circle {
	String name;
	float r; //(전용변수) 멤버변수
	
	public Circle(float r) { //있어도그만 없어도그만, 지워도 실행이 된다. 생성자 : 객체를 만들때 초기값을 넣어준다.
		System.out.println("Circle 생성자"+"\n"); this.r=r; //인자가 있으면 생략할 수 없다. //인자가 없는 생성자는 디폴트생성자.
	}
	
	public Circle() { 
		System.out.println("디폴트 생성자"+"\n"); 
	}
	
	public Circle(float r,String name) {
		System.out.println("두개짜리 생성자"+"\n"); this.r=r; this.name=name;
	}
	
	public void getArea() {
		System.out.println(name+"의 "+"넓이 : "+(3.14*r*r)+"\n");
	}
	public void setR(float r) {      // ,String str){ // 매개변수, 지역변수(메소드에만 표현됨) 위치,순서,일치여부를 모두 따져서 맞을때만 동작
		this.r=r; // this.r은 5번의 r을 가리키는것.
	}
	public void getName() {
		System.out.println("이름 : "+this.name);
	}
	
	public static void main(String[] args) { //괄호 = 함수 args=argument, 관례적
		Circle c1=new Circle(); // 클래스이름과 똑같은 특별한 메소드 - 생성자, 생성자 앞에는 void를 붙이면 안된다.
		c1.name="피자";
		c1.r=10f;
		c1.getName();
		c1.getArea();
		c1.setR(8f);
		c1.getArea();
		
		Circle c2=new Circle();
		c2.name="도넛";
		c2.r=2f;
		c2.getName();
		c2.getArea();
		
		Circle c3=new Circle();
		c3.name="케잌";
		c3.r=15f;
		c3.getName();
		c3.getArea();
		
		Circle c4=new Circle(5f);
		c4.name="김치전";
		c4.getName();
		c4.getArea();
		
		Circle c5=new Circle(4,"파전");
		c5.getName();
		c5.getArea();
	}
}