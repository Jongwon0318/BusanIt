package chap05;
//사각형
public class Square extends Shape{
//좌표(x,y) 가로,세로
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
		System.out.println("높이 : "+height);
		System.out.println("너비 : "+width);
	}
}
