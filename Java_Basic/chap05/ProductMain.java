package chap05;
class Product{
	protected int price;
	protected double bonus; // ��ǰ�� 10%
	public Product(int price) {
		this.price=price;
		bonus=price/10;
	}
	public int getPrice() {
		return price;
	}
	public double getBonus() {
		return bonus;
	}
}

class Buyer {
	private int sum;
	private int cnt;
	private int money;
	double bonusPoint;
	Product[] arr=new Product[10];
	
	public Buyer(int money) {
		this.money=money;
	}
	
	public void buy(Product a) {
		arr[cnt++]=a;
		money-=a.getPrice();
		bonusPoint+=a.getBonus();
	}
	
	public void show() {
		//for(int i=0; i<cnt; i++) {
		//	sum+=arr[i].getPrice();
		//}
		for (Product a : arr) {
			if(a==null) break;
			System.out.println("���Ź�ǰ : "+a);
			sum+=a.price;
		}		
		System.out.println("������ ������ ���� : "+sum);
		System.out.println("�ܾ� : "+money);
		System.out.println("�������ʽ� : "+bonusPoint+"\n");
		sum=0;
	}
}

class Computer extends Product{
	public Computer(int price) {
		super(price);
	}
	public String toString() {
		return "��ǻ��";
	}
}

class PTV extends Product{
	public PTV(int price) {
		super(price);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "tv";
	}
}

class Audio extends Product{
	public Audio(int price) {
		super(price);
	}
	public String toString() {
		return "�����";
	}
}

public class ProductMain {

	public static void main(String[] args) {
		Buyer b1=new Buyer(1000);
		PTV ptv=new PTV(100);
		Computer com =new Computer(50);
		Audio audio=new Audio(70);
		b1.buy(ptv);
		b1.buy(com);
		b1.show();
		b1.buy(audio);
		b1.show();
	}
}
