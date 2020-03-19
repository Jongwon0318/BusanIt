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
		Circle[] arr=new Circle[5]; //����&����
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Circle(i+1); //�ʱ�ȭ
		}
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i].getArea();
			System.out.println("���� : "+arr[i].getArea());
		}
		System.out.println("�Ѹ��� : "+sum);
		/*	Circle c1=new Circle(1); //c1�� Circle��
		Circle c2=new Circle(2);
		Circle c3=new Circle(3);
		Circle c4=new Circle(4);
		Circle c5=new Circle(5);
		System.out.println("���� ���� : "+c1.getArea());
		System.out.println("���� ���� : "+c2.getArea());
		System.out.println("���� ���� : "+c3.getArea());
		System.out.println("���� ���� : "+c4.getArea());
		System.out.println("���� ���� : "+c5.getArea());
		System.out.println("������ ���� : "+c1.getArea()+c2.getArea()+c3.getArea()+c4.getArea()+c5.getArea());
		*/
	}
}
