package chap07;

import java.util.HashMap;

class Student {
	private String id;
	private String tel;

	// ������(id,tel)
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
		map.put("ȫ�浿", new Student("1", "010-1111-1111"));
		map.put("�̼���", new Student("2", "010-2222-2222"));
		map.put("������", new Student("3", "010-3333-3333"));
		Student s = map.get("�̼���");
		System.out.println(s);
		System.out.println("id : " + s.getId() + "\t tel : " + s.getTel());
	}

}
