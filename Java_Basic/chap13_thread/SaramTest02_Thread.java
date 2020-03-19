package chap13_thread;

public class SaramTest02_Thread extends Thread{

	private String name;
	
	public SaramTest02_Thread(String name) {
		this.name=name;
	}
	
	@Override
	public void run() { //같이 움직인다
		for(int i=0; i<5; i++) {
			System.out.println(i+name+"이 말한다.");
		}
	}
	
	public static void main(String[] args) {
		SaramTest02_Thread st1=new SaramTest02_Thread("홍길동");
		SaramTest02_Thread st2=new SaramTest02_Thread("이순신");
		SaramTest02_Thread st3=new SaramTest02_Thread("강감찬");
		st1.start();
		st2.start();
		st3.start();
		
	}

}
