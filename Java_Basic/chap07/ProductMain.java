package chap07;

import java.util.ArrayList;

class Product {
	protected int price;
	protected double bonus; // 제품의 10%

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
		// alist에 p가 있는지 확인가능?
//		if(alist.contains(a)) {
//			alist.remove(a);
//			money+=a.getPrice();
//			bonusPoint-=a.getBonus();
//			System.out.println("반품할물품 : "+a);
//		}
//		else {
//			System.out.println("제품이 없습니다.");
//		}
		
//		for (int i = 0; i < alist.size(); i++) {
//			if (alist.get(i).equals(a)) {
//				alist.remove(a);
//				money += a.getPrice();
//				bonusPoint -= a.getBonus();
//				System.out.println("반품할물품 : " + a);
//			} else {
//				System.out.println("제품이 없습니다.");
//			}
//		}
//		
		for(Product ap : alist) {
			if(ap.equals(a)) {
				alist.remove(a);
				money += a.getPrice();
				bonusPoint -= a.getBonus();
				System.out.println("반품할물품 : " + a);
				break;
			}
		} 
	}

	public void show() {
		// for(int i=0; i<cnt; i++) {
		// sum+=arr[i].getPrice();
		// }
		for (Object a : alist) {
			System.out.println("구매한물품 : " + a);
			sum += ((Product) a).price; // Object는 price가 없음, 최상위객체이므로 반드시 캐스팅 필요
		} // 제네릭 <Product>를 alist생성시에 붙여주면 위처럼 캐스팅을 시킬 필요가 없음.
		System.out.println("구매한 물건의 총합 : " + sum);
		System.out.println("잔액 : " + money);
		System.out.println("보유보너스 : " + bonusPoint + "\n");
		sum = 0;
	}

}

class Computer extends Product {
	public Computer(int price) {
		super(price);
	}

	public String toString() {
		return "컴퓨터";
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
		return "오디오";
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
		b1.refund(ptv); // 반품 alist제거, money+/ point-
		b1.show();
	}
}