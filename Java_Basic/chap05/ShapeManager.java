package chap05;

public class ShapeManager {
	private Shape[] arr=new Shape[10];
	private int cnt;
	
	public static void showMenu() {
		System.out.println("선택하세요..");
		System.out.println("1.원 2.사각형 3.보기 4.종료");
		System.out.print("선택 : ");
	}
	
	public void inputData(int num) { //원 또는 사각형을 입력받아야 한다.
		System.out.println("도형입력....");
		
		System.out.print("x좌표>>");
		int x=ShapeMain.sc.nextInt();
		System.out.print("y좌표>>");
		int y=ShapeMain.sc.nextInt();
		
		if(num==1) {//원
			System.out.print("반지름 : ");
			int r=ShapeMain.sc.nextInt();
			arr[cnt++]=new Circle(x,y,r);
		}
		
		else if(num==2) {//사각형
			System.out.print("너비 : ");
			int w=ShapeMain.sc.nextInt();
			System.out.print("높이 : ");
			int h=ShapeMain.sc.nextInt();
			arr[cnt++]=new Square(x,y,w,h);
		}
	}
	
	public void viewData() { //원 또는 사각형을 출력하여야 한다.
		for(int i=0; i<cnt; i++) {
			arr[i].print();
			System.out.println();
		}
	}
	
	
	
}
