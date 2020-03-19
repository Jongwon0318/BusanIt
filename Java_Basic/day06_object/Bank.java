package day06_object;

public class Bank {
	String name;
	int money;
	
	public Bank() {	
		this.money=0;
	}
	
	public Bank(String name, int money) {
		this.name=name; this.money=money;
	}
	
	public void inputMoney(int input) {
		this.money+=input; System.out.println(input+"원을 입금합니다.");
	}
	
	public void outMoney(int output) {
		if(this.money>=output) {
			this.money-=output; 
			System.out.println(output+"원을 출금합니다.");
		}else System.out.println(name+"님 잔액부족");
		/*
		 * if(money<output) {
		 * System.out.println(name+"님 잔액부족");
		 * return; ----------> 아무것도 하지말고 끝내라!
		 * }
		 */
	}
	
	public void getMoney() {
		System.out.println(name+" 님의 잔액은 : "+money+"원 입니다.");
	}
	
	public static void main(String[] args) {
		Bank b1=new Bank();
		b1.name="홍길동";
		b1.inputMoney(5000);
		b1.outMoney(3000);
		b1.getMoney();
		
		System.out.println("\n=========================\n");
		
		Bank b2=new Bank();
		b2.name="강감찬";
		b2.inputMoney(13000);
		b2.outMoney(15000);
		b2.getMoney();
		
		System.out.println("\n=========================\n");

		Bank b3=new Bank("이순신",6000);
		b3.getMoney();

	}
}