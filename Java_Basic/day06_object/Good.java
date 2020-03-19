package day06_object;

public class Good {
	//변수 선언
	String name,company,serialnum;
	int price;
	double discountrate;
	//생성자
	public Good(String serialnum, String name, String company, int price) {
		this.serialnum=serialnum; this.name=name; this.company=company; this.price=price;
	}
	//가격 도출
	public int getSellingPrice() {
		return price;
	}
	//할인 적용
	public void updateDiscountRate(double discountrate) {
		this.discountrate=discountrate;
		price-=price*discountrate;
		System.out.println(name+" -> "+discountrate*100+"%"+"만큼 할인합니다.");
	}
	//메인 메소드
	public static void main(String[] args) {
		Good g1=new Good("001","레몬","레몬사",1000);
		System.out.println(g1.name+" : "+g1.getSellingPrice()+"원");
		
		Good g2=new Good("002","사과","애플사",1000);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"원");
		g2.updateDiscountRate(0.2);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"원");
		System.out.println(g2.name+"의 할인율 : "+g2.discountrate*100+"%");

		g2.updateDiscountRate(0.1);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"원");
		System.out.println(g2.name+"의 할인율 : "+g2.discountrate*100+"%");
	}
}
