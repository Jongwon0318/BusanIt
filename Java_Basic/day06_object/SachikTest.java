package day06_object;

public class SachikTest {
	int a;
	int b;

	public SachikTest() {}

	public SachikTest(int a, int b) {
		this.a=a; this.b=b;
	}
	
	public void sum() {
		System.out.println(this.a+"+"+this.b+" = "+this.a+this.b);
	}
	
	public float div() { 
		return(a/b);
	}
	public static void main(String[] args) {
		SachikTest sa1=new SachikTest(10,5);
		sa1.sum();
		
		SachikTest sa2=new SachikTest(30,5);
		System.out.println("������ : "+sa2.div()); //������� �ִٴ� ���� return���� �ִٴ� ��
	}
}