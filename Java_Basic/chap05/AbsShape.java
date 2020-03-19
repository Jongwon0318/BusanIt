package chap05;

public abstract class AbsShape {
	public abstract void draw();
	//public void draw(){} 랑 다름!!!!!
	
	public void print() {
		System.out.println("도형그리기");
	}
	
	public abstract void move();
}
