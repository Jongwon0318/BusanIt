package day06_object;

public class Baby { //�ݵ�� Ŭ������ main�� ������ �ִ� ���� �ƴϴ�.
	String name;
	int age; // �������� ��ü���� ������ ��.
	public void smile() {
		System.out.println("���´�");
	}
	public void cry()	{
		System.out.println("���");
	}
	public static void main(String[] args) {
		Baby b1 = new Baby(); //m
		//System.out.println(b1.smile()); �߸��Ȱ�.
		b1.smile(); //7
		b1.age=10; //5
		System.out.println(b1.age); //m
		
		Baby b2 = new Baby(); //m`
		System.out.println(b2.age); //5`
		System.out.println("b1 : "+b1); //m
		System.out.println("b2 : "+b2); //m`
		
		Baby b3 = new Baby(); //m``
		b3.name="ȫ�浿"; //4
		b3.age=2; //5
		System.out.println("�̸� : "+b3.name+"\n"+"���� : "+b3.age);
		b3.cry();
		
		Baby b4; //����
		// Baby b4 = new Baby(); //Baby b4; �� ġ�� ���� , ����� ������ ���ÿ�
		b4 = new Baby(); //����
		b4.name="�̼���";
	}
}