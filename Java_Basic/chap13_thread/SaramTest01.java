package chap13_thread;

public class SaramTest01 {
	
	private String name;
	
	public SaramTest01(String name) {
		this.name=name;
	}
	
	public void speak() {
		for(int i=0; i<5; i++) {
			System.out.println(name+"이 말한다.");
		}
	}
	
	public static void main(String[] args) {
		SaramTest01 s1=new SaramTest01("홍길동");
		SaramTest01 s2=new SaramTest01("이순신");
		SaramTest01 s3=new SaramTest01("강감찬");
		s1.speak();
		s2.speak();
		s3.speak();
	}

}
