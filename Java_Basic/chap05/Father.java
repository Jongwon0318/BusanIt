package chap05;

public class Father extends GrandFather { 
	//GrandFather�� ����Ŭ����, GrandFather�� ���� GrandFather�� �ִ� �����ڸ� ���� ������ ���� �ڽ��� �����ڸ� �����Ѵ�.
	public Father() {
		super("�Ҿƹ���"); //���� ����Ʈ�����ڸ� �ҷ�����. ��Ӱ��迡 �������� ���� �Ƚᵵ �ȴ�.(������ ǥ��)
		System.out.println("Father ������");
	}
	public void fatherMethod() {
		System.out.println("fatherMethod");
	}
	public void grandFatherMethod() {
		System.out.println("grandFatherMethod<---------�ƹ����� ������ ����");
	} //�������̵�
}
