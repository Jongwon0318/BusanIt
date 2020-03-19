package chap13_thread;

public class ThreadTest02_Thread extends Thread{
	private int dan;
	
	public ThreadTest02_Thread(int dan) {
		this.dan=dan;
	}
	
	public void run() {
		for(int i=1; i<10; i++) {
			System.out.println(dan+" * "+i+" = "+dan*i);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest02_Thread t1=new ThreadTest02_Thread(5);
		ThreadTest02_Thread t2=new ThreadTest02_Thread(7);
		ThreadTest02_Thread t3=new ThreadTest02_Thread(3);
		t1.start();
		t2.start();
		t3.start();
	}

}
