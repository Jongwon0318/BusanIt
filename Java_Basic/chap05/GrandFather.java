package chap05;

public class GrandFather {
	protected String value="�������"; //protected : ���� ���� ��ӹ޴� Ŭ�������� ���
	public GrandFather() {
		System.out.println("GrandFather ������");
	}
	public GrandFather(String str) {
		System.out.println(str+"GrandFather ������");
	} //�����ε�
	public void grandFatherMethod() {
		System.out.println("grandFatherMethod");
	}
}
