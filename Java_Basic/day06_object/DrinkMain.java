package day06_object;

public class DrinkMain {
	public static void main(String[] args) {
		Drink d1=new Drink("Ŀ��",300,3);
		d1.getData();//Ŀ�� 300 3 900
		Drink d2=new Drink("����",500,5);
		d2.getData();//���� 450 5 2500
		System.out.println("�Ǹűݾ� : "+d1.getTotal()+d2.getTotal());
	}
}