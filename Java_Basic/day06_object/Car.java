package day06_object;

public class Car {
	String name;
	String color;
	int speed;
	
	public Car(String color) {
		this("미정",color);
	}
	
	public Car(String name, String color) {
		this.name=name; this.color=color;
	}
	public void speedUp(int speed) {
		this.speed+=speed;
		System.out.println("속도를 "+speed+" 만큼 가속합니다.");
	}
	public void speedDown(int speed) {
		this.speed-=speed;
		System.out.println("속도를 "+speed+" 만큼 감속합니다.");
	}
	public void info() {
		System.out.println("색깔 : "+color+"\n"+"차종 : "+name+"\n"+"속도 : "+speed);
	}
	public static void main(String[] args) {
		Car c1=new Car("소나타","흰색");
		c1.speedUp(70);
		c1.speedDown(30);
		c1.info();
		System.out.println("=======================\n");
		
		Car c2=new Car("Black");
		c2.info();
	}
}