package chap05;

public class AbsComputer extends AbsProduct {

	@Override
	public void print() {
		System.out.println("���� ��ǻ��...");
	}

	@Override
	public void turnOn() {
		System.out.println("��ǻ�� ���� �ѱ�");
	}
}