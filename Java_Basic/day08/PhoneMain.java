package day08;
import java.util.Scanner;

class Phone{ //�ϳ��� ���Ͽ� �������� Ŭ������ �� �� �ִ�.
	private String name;
	private String tel;
	
	public Phone(String name, String tel) { //�������� �̸��� Ŭ������ ���ƾ��Ѵ�..!!
		this.name=name; this.tel=tel;
	}
	
	public String getName() { //getter, ���� private���� �����ϴ� ������ �� ���ڸ� �빮�ڷ�.. �޼ҵ带 ���� ���� �ҷ����� ����� ����Ѵ�.
		return name;
	}
	
	public String getTel() {
		return tel;                 
	}
}

public class PhoneMain {
	int n;
	Phone[] arr; //����
	Scanner sc=new Scanner(System.in);
	
//�Է��ϱ�
	public void inputPhone() {
		System.out.println("�Է¼�>>");
		int num=sc.nextInt();
		arr=new Phone[num]; //����
		for(int i=0; i<num; i++) {
			System.out.print("�̸� : ");
			String name=sc.next();
			System.out.print("��ȭ : ");
			String tel=sc.next();
			arr[i]=new Phone(name, tel); //�ʱ�ȭ
		}
	}
	
//�̸��� �����, ������ �̸��� ��ȭ��ȣ ���, ������ ã�� ģ�� �����ϴ�.
	public String searchPhone() {
		System.out.println("ã�� ����� �̸��� �Է��ϼ���.");
		String str="";
		String searchName=sc.next();
		boolean flag=false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(searchName)) {
				flag=true;
				str="�̸� : "+searchName+"/��ȭ��ȣ : "+arr[i].getTel();
			}
		}
		if(flag=false) str="ã�� ģ�� ����";
		return str;
	}
	
//��ü����
	public void viewPhone() {
		for(int i=0; i<arr.length; i++) {
			System.out.println("�̸� : "+arr[i].getName()+"\t"+"��ȭ��ȣ : "+arr[i].getTel()+"\n");
		}
	}

//main��	
	public static void main(String[] args) { //������ ���ϸ��� main���� �����ϴ� Ŭ������..!
		PhoneMain pm=new PhoneMain();
		pm.inputPhone();
		pm.viewPhone();
		System.out.println("ã�� ģ��>>>"+pm.searchPhone());
	}
}