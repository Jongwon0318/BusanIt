package chap13_thread;

public class SaramTest03_Runnable implements Runnable{

	private String name;
	
	public SaramTest03_Runnable(String name) {
		this.name=name;
	}
	
	public static void main(String[] args) {
		SaramTest03_Runnable sr1=new SaramTest03_Runnable("ȫ�浿");
		SaramTest03_Runnable sr2=new SaramTest03_Runnable("������");
		SaramTest03_Runnable sr3=new SaramTest03_Runnable("�̼���");
		
		Thread t1=new Thread(sr1);
		Thread t2=new Thread(sr2);
		Thread t3=new Thread(sr3);
		t1.start();
		t2.start();
		t3.start();
	}

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(name+"�� ���Ѵ�.");
			try {
				Thread.sleep(1000); //1000ms=1sec
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
