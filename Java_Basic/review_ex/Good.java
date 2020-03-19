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
		System.out.println("��ǰ "+name+"�� ������ "+discountRate*100+"%��ŭ �����մϴ�.");
		price-=price*discountRate;
	}
	public static void main(String[] args) {
		Good g1=new Good("001","����","�����",1000);
		System.out.println("���� : "+g1.getSellingPrice());
		
		Good g2=new Good("002","���","���û�",1000);
		System.out.println("��� : "+g2.getSellingPrice());
		g2.updateDiscountRate(0.2);
		System.out.println("��� : "+g2.getSellingPrice());
	}
}
