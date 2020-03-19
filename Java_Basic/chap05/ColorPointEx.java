package chap05;

class Point{
	protected int x,y;	//private int x,y
	public Point() {}
	public Point(int x, int y) {
		this.x=x; this.y=y;
	}
	public void showPoint() {
		System.out.println("( "+x+", "+y+" )");
	}
}

class ColorPoint extends Point{
	ColorPoint(){}
	private String color;
	public ColorPoint(int x, int y, String color) {
		  super(x,y);
		  this.color=color;
	}
	public void showPoint() {
		//super.showPoint();
		System.out.println("( "+x+", "+y+", "+color+" )");
	}
}

public class ColorPointEx extends ColorPoint{
	public ColorPointEx(int x, int y, String color) {
		super(x,y,color);
	}
	
	public static void main(String[] args) {
		Point p=new Point(3,4);
		ColorPoint cp=new ColorPoint(2,5,"Red");
		p.showPoint();
		cp.showPoint();
	}

}