package day07;
import java.util.Scanner;

public class TwoArrayScore {
	static Scanner sc=new Scanner(System.in);
	int[][]arr=new int[50][7];
	int row=0;
	int rank=0;
	//menu
	public void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ��ü����/����");
		System.out.print("���� : ");
	}
	
	//������ �Է� &����,��� ���ϱ�
	public void inputData() {
		System.out.println("������ �Է� ����....");
		System.out.print("�й� : ");
		int yearNum=sc.nextInt();
		System.out.print("�������� : ");
		int kor=sc.nextInt();
		System.out.print("�������� : ");
		int eng=sc.nextInt();
		System.out.print("�������� : ");
		int math=sc.nextInt();
		
		arr[row][0]=yearNum;
		arr[row][1]=kor;
		arr[row][2]=eng;
		arr[row][3]=math;
		arr[row][4]=kor+eng+math;
		arr[row][5]=(arr[row][4])/3;
		arr[row][6]=1;
		row++;
		
	}
	//���� ���ϱ�
	public void rankMethod() {
		for(int i=0; i<row-1; i++) {
			for(int j=i+1; j<row; j++) {
				if(arr[i][4]>arr[j][4]) {
					arr[j][6]++;
				}else if(arr[i][4]<arr[j][4]) {
					arr[i][6]++;
				}
			}
		}
	}

	
	//������ ���
	public void viewData() {
		rankMethod();
		System.out.println("-----------���� ����-----------");
		System.out.println("�й�\t����\t����\t����\t����\t���\t����");
		for(int i=0; i<row; i++) {
			for(int j=0; j<arr[i].length; j++) System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TwoArrayScore manager=new TwoArrayScore();
		while(true) {
			manager.showMenu();
			int num=sc.nextInt();
			switch(num) {
			case 1:manager.inputData(); break; //������ �Է�
			case 2:manager.viewData(); //������ ���
						  System.exit(0); break;//����
			default : System.out.println("�Է¿���");
			}
		}
	}
}
