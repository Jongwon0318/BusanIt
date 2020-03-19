package day06_object;

public class Drink {
	public String name;
	public int price;
	public int cnt;
	
	public Drink(String name, int price , int cnt) {
		this.name=name; this.price=price; this.cnt=cnt;
	}
	
	public int getTotal() {
		return price*cnt;
	}

	public void getData() {
		System.out.println(name+"\t : "+price+"¿ø, "+cnt+"°³ "+" : ÃÑ "+getTotal()+"¿ø");
	}

}