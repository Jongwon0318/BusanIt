package chap04_book;

class TV{
	private String name;
	private int year,size;
	
	public TV(String name, int year, int size) {
		this.name=name; this.year=year; this.size=size;
	}
	
	public void show() {
		System.out.println(name+"���� ���� "+year+"���� "+size+"��ġ TV");
	}
}

public class Mon01 {
	public static void main(String[] args) {
		TV myTV = new TV("LG",2017,32);
		myTV.show();
	}
}