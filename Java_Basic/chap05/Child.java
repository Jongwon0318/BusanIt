package chap05;

public class Child extends Father { 
	//상속은 여러단계 올라가도 상관없다.(끝까지 올라간다)
	//자바는 다중상속을 지원하지 않는다.
	public Child() {
		System.out.println("Child 생성자");
	}
	public void childMethod() {
		System.out.println("childMethod");
	}
	public void fatherMethod() {
		System.out.println("child 오버라이딩 ->fatherMethod");

	}
}
