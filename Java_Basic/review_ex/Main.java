package review_ex;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandFather gf=new GrandFather(); //����Ʈ������
		System.out.println(gf.value);
		Father f=new Father();
		System.out.println(f.value);
		Child c=new Child(); //-->�Ҿƹ���GrandFather������, Father������, Child������
		System.out.println(c.value);
		System.out.println("==================");
		System.out.println(gf.grandFatherMethod());
		System.out.println(f.grandFatherMethod()); //�������̵�(�θ��� �޼ҵ带 �ڽ��� ������ �ϴ� ��)
		System.out.println(c.grandFatherMethod()); //�������̵�
		System.out.println(f.fatherMethod());
		System.out.println(c.fatherMethod()); //�������̵�
		System.out.println(c.childMethod());
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
