package day06_object;

public class Circle {
	String name;
	float r; //(���뺯��) �������
	
	public Circle(float r) { //�־�׸� ����׸�, ������ ������ �ȴ�. ������ : ��ü�� ���鶧 �ʱⰪ�� �־��ش�.
		System.out.println("Circle ������"+"\n"); this.r=r; //���ڰ� ������ ������ �� ����. //���ڰ� ���� �����ڴ� ����Ʈ������.
	}
	
	public Circle() { 
		System.out.println("����Ʈ ������"+"\n"); 
	}
	
	public Circle(float r,String name) {
		System.out.println("�ΰ�¥�� ������"+"\n"); this.r=r; this.name=name;
	}
	
	public void getArea() {
		System.out.println(name+"�� "+"���� : "+(3.14*r*r)+"\n");
	}
	public void setR(float r) {      // ,String str){ // �Ű�����, ��������(�޼ҵ忡�� ǥ����) ��ġ,����,��ġ���θ� ��� ������ �������� ����
		this.r=r; // this.r�� 5���� r�� ����Ű�°�.
	}
	public void getName() {
		System.out.println("�̸� : "+this.name);
	}
	
	public static void main(String[] args) { //��ȣ = �Լ� args=argument, ������
		Circle c1=new Circle(); // Ŭ�����̸��� �Ȱ��� Ư���� �޼ҵ� - ������, ������ �տ��� void�� ���̸� �ȵȴ�.
		c1.name="����";
		c1.r=10f;
		c1.getName();
		c1.getArea();
		c1.setR(8f);
		c1.getArea();
		
		Circle c2=new Circle();
		c2.name="����";
		c2.r=2f;
		c2.getName();
		c2.getArea();
		
		Circle c3=new Circle();
		c3.name="�ɟ�";
		c3.r=15f;
		c3.getName();
		c3.getArea();
		
		Circle c4=new Circle(5f);
		c4.name="��ġ��";
		c4.getName();
		c4.getArea();
		
		Circle c5=new Circle(4,"����");
		c5.getName();
		c5.getArea();
	}
}