package review_ex;
import java.util.Scanner;

class Phone{
	private String name,tel;
	
	public Phone(String name, String tel) {
		this.name=name; this.tel=tel;
	}
	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
}

public class PhoneMain {
	private static Scanner sc=new Scanner(System.in);
	int cnt;
	Phone[] arr;
	
	public PhoneMain() {}
	
	public void inputPhone() {
		System.out.println("�Է¼�>>");
		int num=sc.nextInt();
		arr=new Phone[num];
		for(int i=0; i<num; i++) {
			System.out.print("�̸� : ");
			String name=sc.next();
			System.out.print("��ȭ : ");
			String tel=sc.next();
			arr[i]=new Phone(name, tel);
		}
	}
	
	public void viewPhone() {
		System.out.println("�Էµ� ��ȭ��ȣ�θ� ����մϴ�.");
		for(int i=0; i<arr.length; i++) {
			System.out.println("�̸� : "+arr[i].getName()+"\t"+"��ȭ��ȣ : "+arr[i].getTel()); 
		}
	}
	
	public String searchPhone() {
		System.out.println("ã�� ����� �̸��� �Է��ϼ���.");
		String str="";
		String searchName=sc.next();
		boolean flag=false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(searchName)) {
				flag=true;
				str="�̸� : "+searchName+"/��ȭ��ȣ : "+arr[i].getTel()+"\n";
			}
		}
		if(flag=false) str="ã�� ģ�� ����\n";
		return str;
	}
	
	public static void main(String[] args) {
		PhoneMain pm=new PhoneMain();
		while(true) {
			System.out.println("���α׷��� �����մϴ�.");
			System.out.println("1.������ �Է�");
			System.out.println("2.������ ���");
			System.out.println("3.ģ�� ã��");
			System.out.println("4.����");
			System.out.print("���� : ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1 : 	pm.inputPhone(); break;
			case 2 :	pm.viewPhone(); break;
			case 3 :	System.out.print(pm.searchPhone()); break;
			case 4 : System.out.println("���α׷��� �����մϴ�.");
							System.exit(0);
			default : System.out.println("�Է¿���"); 
			}
		}
	}
}