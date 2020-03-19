package day07_objectArray; //p202

public class Circle {
	private double r;
	private Circle(double r) {
		this.r=r;
	}
	private double getArea() {
		return (r*r*3.14);
	}
	public static void main(String[] args) {
		Circle[] arr=new Circle[5]; //¼±¾ð&»ý¼º
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Circle(i+1); //ÃÊ±âÈ­
		}
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i].getArea();
			System.out.println("¸éÀû : "+arr[i].getArea());
		}
		System.out.println("ÃÑ¸éÀû : "+sum);
		/*	Circle c1=new Circle(1); //c1Àº CircleÇü
		Circle c2=new Circle(2);
		Circle c3=new Circle(3);
		Circle c4=new Circle(4);
		Circle c5=new Circle(5);
		System.out.println("¿øÀÇ ³ÐÀÌ : "+c1.getArea());
		System.out.println("¿øÀÇ ³ÐÀÌ : "+c2.getArea());
		System.out.println("¿øÀÇ ³ÐÀÌ : "+c3.getArea());
		System.out.println("¿øÀÇ ³ÐÀÌ : "+c4.getArea());
		System.out.println("¿øÀÇ ³ÐÀÌ : "+c5.getArea());
		System.out.println("³ÐÀÌÀÇ ÃÑÇÕ : "+c1.getArea()+c2.getArea()+c3.getArea()+c4.getArea()+c5.getArea());
		*/
	}
}
