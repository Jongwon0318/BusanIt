package chap07;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Teacher {
	//SungJuk[] arr=new SungJuk[30]; //�߿� : �迭�� ��ü�� ����!!
	//ArrayList<SungJuk> alist=new ArrayList();
	Vector<SungJuk> alist = new Vector<SungJuk>();
	public static Scanner sc=new Scanner(System.in);
	
	//�����Է�
	//int cnt; // �������,��������, �������� �⺻���� 0..!
	
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
		alist.add(new SungJuk(name,kor,eng,math));
		
		//arr[cnt]=new SungJuk(name,kor,eng,math); //�߿�
		//cnt++;
		//arr[cnt++]=new SungJuk(name,kor,eng,math);
	}
	
	//��ü��������
	public void viewData() {
		System.out.println("========�л� ���� ����========");
		System.out.println("�̸�\t����\t����\t����\t����\t���");

		for(int i=0; i<alist.size(); i++) { //�߿�
			System.out.print(alist.get(i).getName()+"\t");
			System.out.print(alist.get(i).getKor()+"\t");
			System.out.print(alist.get(i).getMath()+"\t");
			System.out.print(alist.get(i).getEng()+"\t");
			System.out.print(alist.get(i).total()+"\t");
			System.out.println(alist.get(i).average()+"\t");
		}
		//������, �����, ��������� ���ϱ�...
		int sum=0; double avg=0; // ���������� �ݵ�� �ʱⰪ�� ����Ѵ�.
		for(int i=0; i<alist.size(); i++) {
			sum+=alist.get(i).total();
			avg=sum/(alist.size()*3);
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
	
