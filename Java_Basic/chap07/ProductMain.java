package chap07;

import java.util.ArrayList;

class Product {
	protected int price;
	protected double bonus; // ��ǰ�� 10%

	public Product(int price) {
		this.price = price;
		bonus = price / 10;
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
	private int money;
	double bonusPoint;
	// Product[] arr=new Product[10];
	ArrayList<Product> alist = new ArrayList();

	public Buyer(int money) {
		this.money = money;
	}

	public void buy(Product a) {
		alist.add(a);
		money -= a.getPrice();
		bonusPoint += a.getBonus();
	}

	public void refund(Product a) {
		// alist�� p�� �ִ��� Ȯ�ΰ���?
//		if(alist.contains(a)) {
//			alist.remove(a);
//			money+=a.getPrice();
//			bonusPoint-=a.getBonus();
//			System.out.println("��ǰ�ҹ�ǰ : "+a);
//		}
//		else {
//			System.out.println("��ǰ�� �����ϴ�.");
//		}
		
//		for (int i = 0; i < alist.size(); i++) {
//			if (alist.get(i).equals(a)) {
//				alist.remove(a);
//				money += a.getPrice();
//				bonusPoint -= a.getBonus();
//				System.out.println("��ǰ�ҹ�ǰ : " + a);
//			} else {
//				System.out.println("��ǰ�� �����ϴ�.");
//			}
//		}
//		
		for(Product ap : alist) {
			if(ap.equals(a)) {
				alist.remove(a);
				money += a.getPrice();
				bonusPoint -= a.getBonus();
				System.out.println("��ǰ�ҹ�ǰ : " + a);
				break;
			}
		} 
	}

	public void show() {
		// for(int i=0; i<cnt; i++) {
		// sum+=arr[i].getPrice();
		// }
		for (Object a : alist) {
			System.out.println("�����ѹ�ǰ : " + a);
			sum += ((Product) a).price; // Object�� price�� ����, �ֻ�����ü�̹Ƿ� �ݵ�� ĳ���� �ʿ�
		} // ���׸� <Product>�� alist�����ÿ� �ٿ��ָ� ��ó�� ĳ������ ��ų �ʿ䰡 ����.
		System.out.println("������ ������ ���� : " + sum);
		System.out.println("�ܾ� : " + money);
		System.out.println("�������ʽ� : " + bonusPoint + "\n");
		sum = 0;
	}

}

class Computer extends Product {
	public Computer(int price) {
		super(price);
	}

	public String toString() {
		return "��ǻ��";
	}
}

class PTV extends Product {
	public PTV(int price) {
		super(price);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "tv";
	}
}

class Audio extends Product {
	public Audio(int price) {
		super(price);
	}

	public String toString() {
		return "�����";
	}
}

public class ProductMain {

	public static void main(String[] args) {
		Buyer b1 = new Buyer(1000);
		PTV ptv = new PTV(100);
		Computer com = new Computer(50);
		Audio audio = new Audio(70);
		b1.buy(ptv);
		b1.buy(com);
		b1.show();
		b1.buy(audio);
		b1.show();
		System.out.println("===============");
		b1.refund(ptv); // ��ǰ alist����, money+/ point-
		b1.show();
	}
}