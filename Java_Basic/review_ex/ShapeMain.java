package review_ex;
import java.util.Scanner;


class Shape{
	protected int x,y;
	public Shape(int x, int y) {
		this.x=x; this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void print() {
		System.out.println("X좌표 : "+getX()+"\n"+"Y좌표 : "+getY());
	}
}

class Circles extends Shape{
	protected double r;
	public Circles(int x, int y, double r) {
		super(x,y);
		this.r=r;
	}
	public double getR() {
		return r;
	}
	public void print() {
		super.print();
		System.out.println("반지름 : "+r);
	}
}

class Square extends Shape{
	protected double width,height;
	public Square(int x, int y, double width, double height) {
		super(x,y);
		this.width=width; this.height=height;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public void print() {
		super.print();
		System.out.println("너비 : "+width);
		System.out.println("높이 : "+width);
	}
}

class ShapeManager{
	Shape[] arr= new Shape[10];
	
	int cnt=0;

	public void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 원");
		System.out.println("2. 사각형");
		System.out.println("3. 정보 출력");
		System.out.println("4. 종료");
		System.out.print("선택>>>> ");
	}
	
	public void inputData(int choice) {
		if (choice==1) {
			System.out.println("원 입력을 시작합니다.");
			System.out.print("X좌표 : ");
			int x=ShapeMain.sc.nextInt();
			System.out.print("Y좌표 : ");
			int y=ShapeMain.sc.nextInt();
			System.out.print("반지름 : ");
			double r=ShapeMain.sc.nextDouble();
			arr[cnt++]=new Circles(x,y,r);			
		}else if(choice==2) {
			System.out.println("사각형 입력을 시작합니다.");
			System.out.print("X좌표 : ");
			int x=ShapeMain.sc.nextInt();
			System.out.print("Y좌표 : ");
			int y=ShapeMain.sc.nextInt();
			System.out.print("너비 : ");
			double width=ShapeMain.sc.nextDouble();
			System.out.print("높이 : ");
			double height=ShapeMain.sc.nextDouble();
			arr[cnt++]=new Square(x,y,width,height);			
		}
	}
	
	public void showData() {
		for(int i=0; i<cnt; i++) {
			arr[i].print();
			System.out.println();
		}
	}
}

public class ShapeMain {
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		ShapeManager sm=new ShapeManager();
		while(true) {
			sm.showMenu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1: sm.inputData(choice); break;
			case 2: sm.inputData(choice); break;
			case 3: sm.showData();
			case 4: System.out.println("프로그램을 종료합니다.");
							System.exit(0);
			default : System.out.println("입력 오류");
			}
		}
	}
}

