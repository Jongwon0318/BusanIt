package chap05;

public abstract class AbsShape {
	public abstract void draw();
	//public void draw(){} �� �ٸ�!!!!!
	
	public void print() {
		System.out.println("�����׸���");
	}
	
	public abstract void move();
}
