package book.exam;

public class Circle {
	public int radius;
	public String name;
	
	public Circle() {
		
	}//생성자 선언
	public double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		Circle pizza; //레퍼런스 변수 선언
		pizza = new Circle(); //객체생성 //14,15=> Circle pizza=new Circle();
		
		pizza.radius=10; //객체 멤버 접근
		pizza.name="자바피자"; //객체 멤버 접근
		double area=pizza.getArea();
		System.out.println(pizza.name+"의 면적은 : "+area);
	}
}