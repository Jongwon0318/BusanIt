package book.exam;

public class Circle {
	public int radius;
	public String name;
	
	public Circle() {
		
	}//������ ����
	public double getArea() {
		return 3.14*radius*radius;
	}
	public static void main(String[] args) {
		Circle pizza; //���۷��� ���� ����
		pizza = new Circle(); //��ü���� //14,15=> Circle pizza=new Circle();
		
		pizza.radius=10; //��ü ��� ����
		pizza.name="�ڹ�����"; //��ü ��� ����
		double area=pizza.getArea();
		System.out.println(pizza.name+"�� ������ : "+area);
	}
}