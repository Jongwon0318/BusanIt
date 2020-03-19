package chap07;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Teacher {
	//SungJuk[] arr=new SungJuk[30]; //중요 : 배열에 객체가 들어간것!!
	//ArrayList<SungJuk> alist=new ArrayList();
	Vector<SungJuk> alist = new Vector<SungJuk>();
	public static Scanner sc=new Scanner(System.in);
	
	//성적입력
	//int cnt; // 멤버변수,전역변수, 정수형의 기본값은 0..!
	
	public void inputData() {
		System.out.println("성적입력시작....");
		System.out.print("이름 : ");
		String name=Teacher.sc.next();
		System.out.print("국어성적 : ");
		int kor=Teacher.sc.nextInt();
		System.out.print("영어성적 : ");
		int eng=Teacher.sc.nextInt();
		System.out.print("수학성적 : ");
		int math=Teacher.sc.nextInt();
		alist.add(new SungJuk(name,kor,eng,math));
		
		//arr[cnt]=new SungJuk(name,kor,eng,math); //중요
		//cnt++;
		//arr[cnt++]=new SungJuk(name,kor,eng,math);
	}
	
	//전체성적보기
	public void viewData() {
		System.out.println("========학생 성적 보기========");
		System.out.println("이름\t국어\t수학\t영어\t총점\t평균");

		for(int i=0; i<alist.size(); i++) { //중요
			System.out.print(alist.get(i).getName()+"\t");
			System.out.print(alist.get(i).getKor()+"\t");
			System.out.print(alist.get(i).getMath()+"\t");
			System.out.print(alist.get(i).getEng()+"\t");
			System.out.print(alist.get(i).total()+"\t");
			System.out.println(alist.get(i).average()+"\t");
		}
		//반총점, 반평균, 반총점평균 구하기...
		int sum=0; double avg=0; // 지역변수는 반드시 초기값을 줘야한다.
		for(int i=0; i<alist.size(); i++) {
			sum+=alist.get(i).total();
			avg=sum/(alist.size()*3);
		}
		System.out.println("반총점 : "+sum+"점"+"\t"+"반평균 : "+avg+"점");
	}
	
	//메뉴보기
	public void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.전체보기");
		System.out.println("3.종료");
		System.out.print("선택 : ");
	}
	
	public static void main(String[] args) {
		Teacher t1=new Teacher();
		while(true) {
			t1.showMenu();
			String choice=t1.sc.next();
			switch(choice) {
			case "1":	t1.inputData(); 	break;
			case "2":	t1.viewData();  break;
			case "3":	System.out.println("프로그램 종료");
							System.exit(0);
			default :System.out.println("입력오류");
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
				System.out.println("입력오류");
				continue;
			}

		}*/
	
