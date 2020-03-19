package chap13_thread;

public class ThreadTest01 {
	private int dan;
	
	public ThreadTest01(int dan) {
		this.dan=dan;
	}
	
	public void cal() {
		for(int i=1; i<10; i++) {
			System.out.println(dan+" * "+i+" = "+dan*i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ThreadTest01 t1=new ThreadTest01(5);
		ThreadTest01 t2=new ThreadTest01(7);
		ThreadTest01 t3=new ThreadTest01(3);
		t1.cal();
		t2.cal();
		t3.cal();
	}

}
