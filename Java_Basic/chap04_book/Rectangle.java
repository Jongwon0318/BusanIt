package chap04_book;

public class Rectangle {
	private int x,y;
	private double width,height;
	private boolean flag = false;
		
	public Rectangle(int x, int y, double width, double height) {
		this.x=x; this.y=y; this.width=width; this.height=height;
	}
	
	public void show() {
		System.out.println("("+x+","+y+")���� ũ�Ⱑ "+width+"x"+height+" = "+(width*height)+"�� �簢��");
	}
	
	public int square() {
		return (int)(width*height);
	}
	
	public boolean contains(Rectangle r) {
		if(x+width>r.x+r.width && y+height>r.y+r.height) flag=true;
		return flag;
	}	
	
	public static void main(String[] args) {
		Rectangle r=new Rectangle(2,2,8,7);
		Rectangle s=new Rectangle(5,5,6,6);
		Rectangle t=new Rectangle(1,1,10,10);
		
		r.show();
		s.show();
		t.show();
		System.out.println("s�� ������ : "+s.square());
		if(t.contains(r)) System.out.println("t�� r�� �����մϴ�.");
		if(t.contains(s)) System.out.println("t�� s�� �����մϴ�.");
	}
}