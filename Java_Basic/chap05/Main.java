package chap05;

public class Main {

	public static void main(String[] args) {
		GrandFather gf=new GrandFather(); //디폴트생성자
		System.out.println(gf.value);
		Father f=new Father();
		System.out.println(f.value);
		Child c=new Child(); //-->할아버지GrandFather생성자, Father생성자, Child생성자
		System.out.println(c.value);
		System.out.println("==================");
		gf.grandFatherMethod();
		f.grandFatherMethod(); //오버라이딩(부모의 메소드를 자식이 재정의 하는 것)
		c.grandFatherMethod(); //오버라이딩
		f.fatherMethod();
		c.fatherMethod(); //오버라이딩
		c.childMethod();
		Father f1;
		Child c1=new Child();
		f1=c1; //f1은 Father객체, Child에 있는 오버라이딩 메소드 접근가능
		c1=(Child)f1; 
		//부모는 자식을 포함할 수 있으나, 묵시적 명시인 경우 자식은 부모를 포함할 수 없다.(강제형변환은 가능)
		f1.fatherMethod(); //----> child 오버라이딩->fatherMethod
		
		Father f2=new Child(); // 19,20,21번 라인모두포함
		//f2.childMethod();는 불가능, child객체가 오버라이딩 한 메소드만 불러올수있음
		f2.fatherMethod(); //----> child 오버라이딩->fatherMethod
		
		
	}

}
