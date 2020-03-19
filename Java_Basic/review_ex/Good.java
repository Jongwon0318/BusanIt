package review_ex;

public class Good {
	public String serial, name, company;
	public int price;
	public double discountRate;
	
	public Good(String serial, String name, String company, int price) {
		this.serial=serial; this.name=name; this.company=company; this.price=price;
	}
	
	public int getSellingPrice() {
		return price;
	}
	
	public void updateDiscountRate(double discountRate) {
		this.discountRate=discountRate;
		System.out.println("제품 "+name+"의 가격을 "+discountRate*100+"%만큼 할인합니다.");
		price-=price*discountRate;
	}
	public static void main(String[] args) {
		Good g1=new Good("001","레몬","레몬사",1000);
		System.out.println("레몬 : "+g1.getSellingPrice());
		
		Good g2=new Good("002","사과","애플사",1000);
		System.out.println("사과 : "+g2.getSellingPrice());
		g2.updateDiscountRate(0.2);
		System.out.println("사과 : "+g2.getSellingPrice());
	}
}
