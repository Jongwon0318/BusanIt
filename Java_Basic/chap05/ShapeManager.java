package chap05;

public class ShapeManager {
	private Shape[] arr=new Shape[10];
	private int cnt;
	
	public static void showMenu() {
		System.out.println("�����ϼ���..");
		System.out.println("1.�� 2.�簢�� 3.���� 4.����");
		System.out.print("���� : ");
	}
	
	public void inputData(int num) { //�� �Ǵ� �簢���� �Է¹޾ƾ� �Ѵ�.
		System.out.println("�����Է�....");
		
		System.out.print("x��ǥ>>");
		int x=ShapeMain.sc.nextInt();
		System.out.print("y��ǥ>>");
		int y=ShapeMain.sc.nextInt();
		
		if(num==1) {//��
			System.out.print("������ : ");
			int r=ShapeMain.sc.nextInt();
			arr[cnt++]=new Circle(x,y,r);
		}
		
		else if(num==2) {//�簢��
			System.out.print("�ʺ� : ");
			int w=ShapeMain.sc.nextInt();
			System.out.print("���� : ");
			int h=ShapeMain.sc.nextInt();
			arr[cnt++]=new Square(x,y,w,h);
		}
	}
	
	public void viewData() { //�� �Ǵ� �簢���� ����Ͽ��� �Ѵ�.
		for(int i=0; i<cnt; i++) {
			arr[i].print();
			System.out.println();
		}
	}
	
	
	
}
