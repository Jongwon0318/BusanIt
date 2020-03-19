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
		System.out.println("X��ǥ : "+getX()+"\n"+"Y��ǥ : "+getY());
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
		System.out.println("������ : "+r);
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
		System.out.println("�ʺ� : "+width);
		System.out.println("���� : "+width);
	}
}

class ShapeManager{
	Shape[] arr= new Shape[10];
	
	int cnt=0;

	public void showMenu() {
		System.out.println("�����ϼ���...");
		System.out.println("1. ��");
		System.out.println("2. �簢��");
		System.out.println("3. ���� ���");
		System.out.println("4. ����");
		System.out.print("����>>>> ");
	}
	
	public void inputData(int choice) {
		if (choice==1) {
			System.out.println("�� �Է��� �����մϴ�.");
			System.out.print("X��ǥ : ");
			int x=ShapeMain.sc.nextInt();
			System.out.print("Y��ǥ : ");
			int y=ShapeMain.sc.nextInt();
			System.out.print("������ : ");
			double r=ShapeMain.sc.nextDouble();
			arr[cnt++]=new Circles(x,y,r);			
		}else if(choice==2) {
			System.out.println("�簢�� �Է��� �����մϴ�.");
			System.out.print("X��ǥ : ");
			int x=ShapeMain.sc.nextInt();
			System.out.print("Y��ǥ : ");
			int y=ShapeMain.sc.nextInt();
			System.out.print("�ʺ� : ");
			double width=ShapeMain.sc.nextDouble();
			System.out.print("���� : ");
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
			case 4: System.out.println("���α׷��� �����մϴ�.");
							System.exit(0);
			default : System.out.println("�Է� ����");
			}
		}
	}
}

