package chap05;
//�簢��
public class Square extends Shape{
//��ǥ(x,y) ����,����
	private int height;
	private int width;
	public Square(int x, int y, int height, int width) {
		super(x,y);
		this.height=height; this.width=width;
	}
	
	public int getSquare() {
		return height*width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void print() {
		super.print();
		System.out.println("���� : "+height);
		System.out.println("�ʺ� : "+width);
	}
}
