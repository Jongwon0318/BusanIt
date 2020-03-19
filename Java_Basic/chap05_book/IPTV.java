package chap05_book;

public class IPTV extends ColorTV{
	private String addr;
	
	public IPTV(String addr, int size, int color) {
		super(size,color);
		this.addr=addr;
	}
	@Override //�˷��ش�
	public void printProperty() {
		System.out.println("���� IPTV�� "
				+addr+" �ּ��� ");
		super.printProperty();
	}
	/*public void printProperty() { //�������̵�
		System.out.println("���� IPTV�� "
											+addr+" �ּ��� "
											+getSize()+"��ġ "
											+getColor()+"�÷�"); //super.printProperty();
	}*/
	
	public static void main(String[] args) {
		IPTV iptv=new IPTV("192.1.1.2",32,2048);
		iptv.printProperty();
	}
}
