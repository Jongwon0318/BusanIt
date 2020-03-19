package review_ex;

public class Drink {
	public String name;
	public int price;
	public int cnt;
	public Drink(String name, int price, int cnt) {
		this.name=name; this.price=price; this.cnt=cnt;
	}
	public void getData() {
		System.out.println("이름 : "+name+"\t"+"가격 : "+price+"\t"+"수량 : "+cnt);
	}
	
	public static void main(String[] args) {
		Drink d1=new Drink("커피",300,3);
		d1.getData();
		Drink d2=new Drink("녹차",500,5);
		d2.getData();
	}
}
