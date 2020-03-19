package review_ex;

import java.util.HashMap;

class Studentex {
	private String id;
	private String tel;
	
	protected Studentex(String id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public String getTel() {
		return tel;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}

public class HashMapStudentEx{
	public static void main(String[] args) {
		//Hashmap안에 key값은 String, value값은 Student	
		HashMap <String, Student> map=new HashMap<>();
	}
}
