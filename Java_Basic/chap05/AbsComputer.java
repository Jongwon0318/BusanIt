package chap05;

public class AbsComputer extends AbsProduct {

	@Override
	public void print() {
		System.out.println("나는 컴퓨터...");
	}

	@Override
	public void turnOn() {
		System.out.println("컴퓨터 전원 켜기");
	}
}