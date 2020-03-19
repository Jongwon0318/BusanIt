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
		this.money+=input; System.out.println(input+"���� �Ա��մϴ�.");
	}
	
	public void outMoney(int output) {
		if(this.money>=output) {
			this.money-=output; 
			System.out.println(output+"���� ����մϴ�.");
		}else System.out.println(name+"�� �ܾ׺���");
		/*
		 * if(money<output) {
		 * System.out.println(name+"�� �ܾ׺���");
		 * return; ----------> �ƹ��͵� �������� ������!
		 * }
		 */
	}
	
	public void getMoney() {
		System.out.println(name+" ���� �ܾ��� : "+money+"�� �Դϴ�.");
	}
	
	public static void main(String[] args) {
		Bank b1=new Bank();
		b1.name="ȫ�浿";
		b1.inputMoney(5000);
		b1.outMoney(3000);
		b1.getMoney();
		
		System.out.println("\n=========================\n");
		
		Bank b2=new Bank();
		b2.name="������";
		b2.inputMoney(13000);
		b2.outMoney(15000);
		b2.getMoney();
		
		System.out.println("\n=========================\n");

		Bank b3=new Bank("�̼���",6000);
		b3.getMoney();

	}
}