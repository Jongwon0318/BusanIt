package chap05;

public class Father extends GrandFather { 
	//GrandFather는 상위클래스, GrandFather에 가서 GrandFather에 있는 생성자를 먼저 수행한 다음 자신의 생성자를 수행한다.
	public Father() {
		super("할아버지"); //상위 디폴트생성자를 불러낸다. 상속관계에 있을때는 굳이 안써도 된다.(무조건 표츌)
		System.out.println("Father 생성자");
	}
	public void fatherMethod() {
		System.out.println("fatherMethod");
	}
	public void grandFatherMethod() {
		System.out.println("grandFatherMethod<---------아버지가 수정할 예정");
	} //오버라이딩
}
