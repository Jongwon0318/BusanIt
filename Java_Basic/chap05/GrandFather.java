package chap05;

public class GrandFather {
	protected String value="재산있음"; //protected : 나와 나를 상속받는 클래스까지 허용
	public GrandFather() {
		System.out.println("GrandFather 생성자");
	}
	public GrandFather(String str) {
		System.out.println(str+"GrandFather 생성자");
	} //오버로딩
	public void grandFatherMethod() {
		System.out.println("grandFatherMethod");
	}
}
