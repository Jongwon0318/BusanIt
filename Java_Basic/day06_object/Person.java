package day06_object;

public class Person {
	public String name;
	public int age;
	public float weight;
	public float height;
	public String addr;
	public String tel;
	
	public Person() {} //����Ʈ ������
	
	public Person(String name,int age,String addr) {
		this.name=name; this.age=age; this.addr=addr;
	}
	
	public void study(){
		System.out.println(name+" �� �����Ѵ�.");
	}
	
	public void run(){
		System.out.println(name+" �� ��Ѵ�.");
	}
	
	public void drink(){
		System.out.println(name+" �� ���Ŵ�.");
	}
}