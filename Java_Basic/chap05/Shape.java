package chap05;

public class Shape {
	private int x;
	private int y;
	
	public Shape(int x, int y){
		this.x=x; this.y=y;
	}
	public void print() {
		System.out.println("��ǥ(x.y) : ("+x+","+y+")");
	}
}
