package day08;
import java.util.Scanner;

public class Teacher {
	SungJuk[] arr=new SungJuk[30]; //�߿� : �迭�� ��ü�� ����!!
	
	public static Scanner sc=new Scanner(System.in);
	
	//�����Է�
	int cnt; // �������,��������, �������� �⺻���� 0..!
	
	public void inputData() {
		System.out.println("�����Է½���....");
		System.out.print("�̸� : ");
		String name=Teacher.sc.next();
		System.out.print("����� : ");
		int kor=Teacher.sc.nextInt();
		System.out.print("����� : ");
		int eng=Teacher.sc.nextInt();
		System.out.print("���м��� : ");
		int math=Teacher.sc.nextInt();
		arr[cnt]=new SungJuk(name,kor,eng,math); //�߿�
		cnt++;
		//arr[cnt++]=new SungJuk(name,kor,eng,math);
	}
	
	//��ü��������
	public void viewData() {
		System.out.println("========�л� ���� ����========");
		System.out.println("�̸�\t����\t����\t����\t����\t���");

		for(int i=0; i<cnt; i++) { //�߿�
			System.out.print(arr[i].getName()+"\t");
			System.out.print(arr[i].getKor()+"\t");
			System.out.print(arr[i].getMath()+"\t");
			System.out.print(arr[i].getEng()+"\t");
			System.out.print(arr[i].total()+"\t");
			System.out.println(arr[i].average()+"\t");
		}
		//������, �����, ��������� ���ϱ�...
		int sum=0; double avg=0; // ���������� �ݵ�� �ʱⰪ�� ����Ѵ�.
		for(int i=0; i<cnt; i++) {
			sum+=arr[i].total();
			avg=sum/(cnt*3);
		}
		System.out.println("������ : "+sum+"��"+"\t"+"����� : "+avg+"��");
	}
	
	//�޴�����
	public void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1.������ �Է�");
		System.out.println("2.��ü����");
		System.out.println("3.����");
		System.out.print("���� : ");
	}
	
	public static void main(String[] args) {
		Teacher t1=new Teacher();
		while(true) {
			t1.showMenu();
			String choice=t1.sc.next();
			switch(choice) {
			case "1":	t1.inputData(); 	break;
			case "2":	t1.viewData();  break;
			case "3":	System.out.println("���α׷� ����");
							System.exit(0);
			default :System.out.println("�Է¿���");
			}
		}
	}
}
		
		
		
		
		
		/*while(true) {
			t1.showMenu();
			int choice=sc.nextInt();
			if (choice==1) {
				t1.inputData();
			}else if(choice==2) {
				t1.viewData();
			}else if(choice==3) {
				break;
			}else {
				System.out.println("�Է¿���");
				continue;
			}

		}*/
	
