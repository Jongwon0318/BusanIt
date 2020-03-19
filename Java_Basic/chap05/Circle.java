package chap05;

public class Circle extends Shape{
	//�߽���ǥ (x,y) ������ r
	private int r;
	
	public Circle(int x, int y, int r) {
		super(x,y);
		this.r=r;
	}
	
	public double getCircle() {
		return r*r*3.14;
	}
	public void print() {
		super.print();
		System.out.println("������ : "+r);
	}
}
