package chap05;

public class AbsCircle extends AbsShape {

	@Override
	public void draw() {
		System.out.println("원그리기");
	}


	@Override
	public void move() {
		System.out.println("원 옮기기");
	}
}