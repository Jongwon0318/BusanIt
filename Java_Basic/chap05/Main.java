package chap05;

public class Main {

	public static void main(String[] args) {
		GrandFather gf=new GrandFather(); //����Ʈ������
		System.out.println(gf.value);
		Father f=new Father();
		System.out.println(f.value);
		Child c=new Child(); //-->�Ҿƹ���GrandFather������, Father������, Child������
		System.out.println(c.value);
		System.out.println("==================");
		gf.grandFatherMethod();
		f.grandFatherMethod(); //�������̵�(�θ��� �޼ҵ带 �ڽ��� ������ �ϴ� ��)
		c.grandFatherMethod(); //�������̵�
		f.fatherMethod();
		c.fatherMethod(); //�������̵�
		c.childMethod();
		Father f1;
		Child c1=new Child();
		f1=c1; //f1�� Father��ü, Child�� �ִ� �������̵� �޼ҵ� ���ٰ���
		c1=(Child)f1; 
		//�θ�� �ڽ��� ������ �� ������, ������ ����� ��� �ڽ��� �θ� ������ �� ����.(��������ȯ�� ����)
		f1.fatherMethod(); //----> child �������̵�->fatherMethod
		
		Father f2=new Child(); // 19,20,21�� ���θ������
		//f2.childMethod();�� �Ұ���, child��ü�� �������̵� �� �޼ҵ常 �ҷ��ü�����
		f2.fatherMethod(); //----> child �������̵�->fatherMethod
		
		
	}

}
