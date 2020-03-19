package chap13_thread;

public class ThreadTest03_Runnable implements Runnable{

	private int dan;
	
	public ThreadTest03_Runnable(int dan) {
		this.dan=dan;
	}	
	public static void main(String[] args) {
		ThreadTest03_Runnable tt1=new ThreadTest03_Runnable(5);
		ThreadTest03_Runnable tt2=new ThreadTest03_Runnable(7);
		ThreadTest03_Runnable tt3=new ThreadTest03_Runnable(3);
		
		Thread t1=new Thread(tt1);
		Thread t2=new Thread(tt2);
		Thread t3=new Thread(tt3);
		
		t1.start();
		t2.start();
		t3.start();
	}


	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println(dan+" * "+i+" = "+dan*i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
