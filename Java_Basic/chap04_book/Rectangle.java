package chap04_book;

public class Rectangle {
	private int x,y;
	private double width,height;
	private boolean flag = false;
		
	public Rectangle(int x, int y, double width, double height) {
		this.x=x; this.y=y; this.width=width; this.height=height;
	}
	
	public void show() {
		System.out.println("("+x+","+y+")에서 크기가 "+width+"x"+height+" = "+(width*height)+"인 사각형");
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
		System.out.println("s의 면적은 : "+s.square());
		if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
		if(t.contains(s)) System.out.println("t는 s를 포함합니다.");
	}
}