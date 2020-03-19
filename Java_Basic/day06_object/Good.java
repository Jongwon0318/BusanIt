package day06_object;

public class Good {
	//���� ����
	String name,company,serialnum;
	int price;
	double discountrate;
	//������
	public Good(String serialnum, String name, String company, int price) {
		this.serialnum=serialnum; this.name=name; this.company=company; this.price=price;
	}
	//���� ����
	public int getSellingPrice() {
		return price;
	}
	//���� ����
	public void updateDiscountRate(double discountrate) {
		this.discountrate=discountrate;
		price-=price*discountrate;
		System.out.println(name+" -> "+discountrate*100+"%"+"��ŭ �����մϴ�.");
	}
	//���� �޼ҵ�
	public static void main(String[] args) {
		Good g1=new Good("001","����","�����",1000);
		System.out.println(g1.name+" : "+g1.getSellingPrice()+"��");
		
		Good g2=new Good("002","���","���û�",1000);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"��");
		g2.updateDiscountRate(0.2);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"��");
		System.out.println(g2.name+"�� ������ : "+g2.discountrate*100+"%");

		g2.updateDiscountRate(0.1);
		System.out.println(g2.name+" : "+g2.getSellingPrice()+"��");
		System.out.println(g2.name+"�� ������ : "+g2.discountrate*100+"%");
	}
}
