package day06_object;

public class Car {
	String name;
	String color;
	int speed;
	
	public Car(String color) {
		this("����",color);
	}
	
	public Car(String name, String color) {
		this.name=name; this.color=color;
	}
	public void speedUp(int speed) {
		this.speed+=speed;
		System.out.println("�ӵ��� "+speed+" ��ŭ �����մϴ�.");
	}
	public void speedDown(int speed) {
		this.speed-=speed;
		System.out.println("�ӵ��� "+speed+" ��ŭ �����մϴ�.");
	}
	public void info() {
		System.out.println("���� : "+color+"\n"+"���� : "+name+"\n"+"�ӵ� : "+speed);
	}
	public static void main(String[] args) {
		Car c1=new Car("�ҳ�Ÿ","���");
		c1.speedUp(70);
		c1.speedDown(30);
		c1.info();
		System.out.println("=======================\n");
		
		Car c2=new Car("Black");
		c2.info();
	}
}