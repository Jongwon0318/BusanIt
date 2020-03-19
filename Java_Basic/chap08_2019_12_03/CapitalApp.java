package chap08_2019_12_03;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class CapitalApp {
	 static Scanner sc=new Scanner(System.in);

	private HashMap<String,String>map
	=new HashMap<String,String>();

	public CapitalApp() {
		map.put("�ѱ�","����");
		map.put("�Ϻ�", "����");
		map.put("������", "�ĸ�");
		map.put("�߱�", "����¡");
		map.put("����", "����");
		map.put("�̱�", "������");
	}
	public static void showMenu() { //static ���� ���� ���ο� ������ƽ�� �ֱ⶧����
		System.out.println("***���� ���߱� ������ �����մϴ�.**");
		System.out.println("�Է�:1, ����:2, ����:3>>");

	}
	private void input() { // static �Ⱦ�������....
		System.out.println("����"+map.size()+"�� ����� ���� �Է�"); //map.size :map�� ũ���� ����
		System.out.println("����� x");
		while(true) {
			System.out.println("����� ���� �Է�. ����� x>>");

			String cont=sc.next();//����
			if(cont.toUpperCase().contentEquals("X")) break;
			if(map.containsKey(cont)) {//map�� �Է��� ���� �����ϴ��� 
				System.out.println("�̹� �Է��� �����Դϴ�.");
				continue; //while���� ���ư��� ? 
			}
			String sudo=sc.next(); //����
			map.put(cont,sudo);}
	}private void test() {//��ǻ�Ͱ� �����ϰ� ���ø� �˷��ָ� �׿� ���� ������ �Է��ϸ� �� �Ǵ�����!
		Set<String> set=map.keySet();//���� ������
		Object[] arr= set.toArray();//set�� �迭 ���·� ��ȯ(������ �˱�����)
		while(true) {
			int n=(int)(Math.random()*map.size()); //�����߻�
			String city =(String) arr[n];//���� �̸�  String�ϴ�����: arr�� obj��ü(�ֻ�����ä)�ϱ�String ���� ��ȯ�������.
			String dosi=map.get(city);

			//������ü
			System.out.println(city+"�� ������?����� x");
			String dap= sc.next();
			if(dap.toLowerCase().contentEquals("x")) break;
			if(dap.contentEquals(dosi)) {
				System.out.println("����");}
			else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}
		}
	}

	public static void main(String[] args) {
		CapitalApp ca = new CapitalApp();
		while(true) {
			CapitalApp.showMenu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:ca.input(); break;
			case 2:ca.test(); break;
			case 3: System.out.println("����");
			System.exit(0);
			default:System.out.println("�Է¿���");
			}
		}
	}
}