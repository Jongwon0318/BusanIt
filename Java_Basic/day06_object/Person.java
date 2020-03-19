package day06_object;

public class Person {
	public String name;
	public int age;
	public float weight;
	public float height;
	public String addr;
	public String tel;
	
	public Person() {} //디폴트 생성자
	
	public Person(String name,int age,String addr) {
		this.name=name; this.age=age; this.addr=addr;
	}
	
	public void study(){
		System.out.println(name+" 님 공부한다.");
	}
	
	public void run(){
		System.out.println(name+" 님 운동한다.");
	}
	
	public void drink(){
		System.out.println(name+" 님 마신다.");
	}
}