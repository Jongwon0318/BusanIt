package chap07;

import java.util.HashMap;

class Student {
	private String id;
	private String tel;

	// 생성자(id,tel)
	public Student(String id, String tel) {
		this.id = id;
		this.tel = tel;
	}

	// getter
	public String getId() {
		return id;
	}

	public String getTel() {
		return tel;
	}
	
	public String toString() {
		return "id = "+id+"\t tel = "+tel;
	}
}

public class HashMapStudentEx {
	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<>();
		map.put("홍길동", new Student("1", "010-1111-1111"));
		map.put("이순신", new Student("2", "010-2222-2222"));
		map.put("강감찬", new Student("3", "010-3333-3333"));
		Student s = map.get("이순신");
		System.out.println(s);
		System.out.println("id : " + s.getId() + "\t tel : " + s.getTel());
	}

}
