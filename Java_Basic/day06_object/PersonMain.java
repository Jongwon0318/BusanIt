package day06_object;

public class PersonMain {
	public static void main(String[] args) {
		Person p1=new Person();
		p1.name="홍길동";
		p1.addr="부산";
		System.out.println("이름 : "+p1.name+"\n"+"주소 : "+p1.addr);
		p1.study();
		
		Person p2=new Person();
		p2.name="강감찬";
		p2.addr="서울";
		p2.tel="010-1111-2222";
		System.out.println("\n"+"이름 : "+p2.name+"\n"+"주소 : "+p2.addr+"\n"+"전화번호 : "+p2.tel);
		p2.run();
		
		Baby baby=new Baby();
		baby.name="애기";
		System.out.println("\n"+baby.name);
		baby.smile();
		
		Person p3=new Person("이순신",20,"인천");
		System.out.println("\n"+"이름 : "+p3.name+"\n"+"나이 : "+p3.age+"\n"+"주소 : "+p3.addr);
		p3.study();
	}
}