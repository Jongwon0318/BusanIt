package review_ex;
import java.util.Scanner;

public class TwoArrayScore {
	int n=0;
	int tot;
	int avg;
	static Scanner sc=new Scanner(System.in);

	int[][] arr=new int[50][7];
	//menu
	public void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ������ �Է�");
		System.out.println("2. ��ü����/����");
		System.out.print("���� : ");
	}
	//������ �Է�& ����,��� ���ϱ�
	public void inputData() {
		System.out.println("�����͸� �Է��մϴ�.");
		System.out.print("�й� : ");
		int yearNum=sc.nextInt();
		System.out.print("�������� : ");
		int kor=sc.nextInt();
		System.out.print("�������� : ");
		int eng=sc.nextInt();
		System.out.print("�������� : ");
		int math=sc.nextInt();
		tot=kor+eng+math;
		avg=tot/3;
		arr[n][0]=yearNum;
		arr[n][1]=kor;
		arr[n][2]=eng;
		arr[n][3]=math;
		arr[n][4]=kor+eng+math;
		arr[n][5]=(kor+eng+math)/3;
		arr[n][6]=1;
		n++;
	}
	//�������ϱ�
	public void rankMethod() {
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				//if(arr[i][j]<)
				if(arr[i][4]>arr[j][4]) {
					arr[j][6]++;
				}else if (arr[i][4]<arr[j][4]) {
					arr[i][6]++;
				}
			}
		}
	}
	
	
	
	
	//������ ���
	public void showData() {
		System.out.println("�й�\t����\t����\t����\t����\t���\t����");
		for(int i=0; i<n; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TwoArrayScore manager=new TwoArrayScore();
		while(true) {
			manager.showMenu();
			int num=sc.nextInt();
			if (num==1) {
				manager.inputData();
			}else if(num==2) {
				manager.rankMethod();
				manager.showData();
				System.exit(0); break;
			}else {
				System.out.println("====�Է� ����====");
				continue;
			}
			
		}
	}
}