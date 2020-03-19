package chap05_book;

public class IPTV extends ColorTV{
	private String addr;
	
	public IPTV(String addr, int size, int color) {
		super(size,color);
		this.addr=addr;
	}
	@Override //알려준다
	public void printProperty() {
		System.out.println("나의 IPTV는 "
				+addr+" 주소의 ");
		super.printProperty();
	}
	/*public void printProperty() { //오버라이딩
		System.out.println("나의 IPTV는 "
											+addr+" 주소의 "
											+getSize()+"인치 "
											+getColor()+"컬러"); //super.printProperty();
	}*/
	
	public static void main(String[] args) {
		IPTV iptv=new IPTV("192.1.1.2",32,2048);
		iptv.printProperty();
	}
}
