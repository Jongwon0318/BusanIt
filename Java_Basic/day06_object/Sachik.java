package day06_object;

public class Sachik {
	int a;
	int b;
	
	public Sachik() {}
	public Sachik(int a, int b) {
		this.a=a; this.b=b;
	}
	

	
	public void sum(int a, int b) {
		System.out.println("a"+"+"+"b"+" = "+(a+b));
	}
	public void sub(int a, int b) {
		System.out.println("a"+"-"+"b"+" = "+(a-b));
	}
	public void mul(int a, int b) {
		System.out.println("a"+"*"+"b"+" = "+(a*b));
	}
	public int div(int a, int b) { //void = return�� ����.
		return a/b;
	}
	
	public static void main(String[] args) {
		Sachik s1=new Sachik();
		s1.sum(10,5);
		s1.sub(10,5);
		s1.mul(10,5);
		System.out.println("������ : "+s1.div(10,5));
	}
}