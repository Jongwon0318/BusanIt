package day06_object;

public class PersonMain {
	public static void main(String[] args) {
		Person p1=new Person();
		p1.name="ȫ�浿";
		p1.addr="�λ�";
		System.out.println("�̸� : "+p1.name+"\n"+"�ּ� : "+p1.addr);
		p1.study();
		
		Person p2=new Person();
		p2.name="������";
		p2.addr="����";
		p2.tel="010-1111-2222";
		System.out.println("\n"+"�̸� : "+p2.name+"\n"+"�ּ� : "+p2.addr+"\n"+"��ȭ��ȣ : "+p2.tel);
		p2.run();
		
		Baby baby=new Baby();
		baby.name="�ֱ�";
		System.out.println("\n"+baby.name);
		baby.smile();
		
		Person p3=new Person("�̼���",20,"��õ");
		System.out.println("\n"+"�̸� : "+p3.name+"\n"+"���� : "+p3.age+"\n"+"�ּ� : "+p3.addr);
		p3.study();
	}
}