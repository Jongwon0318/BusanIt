package chap13_thread;

public class SaramTest02_Thread extends Thread{

	private String name;
	
	public SaramTest02_Thread(String name) {
		this.name=name;
	}
	
	@Override
	public void run() { //���� �����δ�
		for(int i=0; i<5; i++) {
			System.out.println(i+name+"�� ���Ѵ�.");
		}
	}
	
	public static void main(String[] args) {
		SaramTest02_Thread st1=new SaramTest02_Thread("ȫ�浿");
		SaramTest02_Thread st2=new SaramTest02_Thread("�̼���");
		SaramTest02_Thread st3=new SaramTest02_Thread("������");
		st1.start();
		st2.start();
		st3.start();
		
	}

}
