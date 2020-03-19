package day06_object;

public class DrinkMain {
	public static void main(String[] args) {
		Drink d1=new Drink("커피",300,3);
		d1.getData();//커피 300 3 900
		Drink d2=new Drink("녹차",500,5);
		d2.getData();//녹차 450 5 2500
		System.out.println("판매금액 : "+d1.getTotal()+d2.getTotal());
	}
}