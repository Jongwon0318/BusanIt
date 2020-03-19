package day07;
import java.util.Scanner;

public class TwoArrayScore {
	static Scanner sc=new Scanner(System.in);
	int[][]arr=new int[50][7];
	int row=0;
	int rank=0;
	//menu
	public void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 전체보기/종료");
		System.out.print("선택 : ");
	}
	
	//데이터 입력 &총점,평균 구하기
	public void inputData() {
		System.out.println("데이터 입력 시작....");
		System.out.print("학번 : ");
		int yearNum=sc.nextInt();
		System.out.print("국어점수 : ");
		int kor=sc.nextInt();
		System.out.print("영어점수 : ");
		int eng=sc.nextInt();
		System.out.print("수학점수 : ");
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
	//석차 구하기
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

	
	//데이터 출력
	public void viewData() {
		rankMethod();
		System.out.println("-----------성적 보기-----------");
		System.out.println("학번\t국어\t수학\t영어\t총점\t평균\t순위");
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
			case 1:manager.inputData(); break; //데이터 입력
			case 2:manager.viewData(); //데이터 출력
						  System.exit(0); break;//종료
			default : System.out.println("입력오류");
			}
		}
	}
}
