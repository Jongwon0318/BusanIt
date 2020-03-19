package chap07_book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
	// 이름,학과,학번,학점평균
	private String name;
	private String department;
	private String id;
	private double grade;

	// getter,setter 편하게 만들기
	// getter
	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getId() {
		return id;
	}

	public double getGrade() {
		return grade;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}

public class Mon5_01 {
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> alist = new ArrayList<>();


	public void insert() {
		for (int i = 0; i < 4; i++) {
			Student st = new Student();
			System.out.println("학생이름,학과,학번,학점평균 입력하세요. \n 예) 백종원, 부동산,1,4.0");
					//황기태,모바일,1,4.1 이재문,안드로이드,2,3.9 김남윤,웹공학,3,3.5 최찬미,빅데이터,4,4.25
			String str = sc.nextLine();
			String[] arr = str.split(",");
			st.setName(arr[0]);
			st.setDepartment(arr[1]);
			st.setId(arr[2]);
			st.setGrade(Double.parseDouble(arr[3]));
			alist.add(st);
		}
	}

	public void print() {
		System.out.println("-----------------------");
		//3가지 방법 다 맞음
		
		for (int i = 0; i <alist.size(); i++) {
			System.out.println("이름 : " + alist.get(i).getName());
			System.out.println("학과 : " + alist.get(i).getDepartment());
			System.out.println("학번 : " + alist.get(i).getId());
			System.out.println("학점평균 : " + alist.get(i).getGrade());
			System.out.println("-----------------------");
		}

		for (Student s : alist) {
			System.out.println("이름 : " + s.getName());
			System.out.println("학과 : " + s.getDepartment());
			System.out.println("학번 : " + s.getId());
			System.out.println("학점평균 : " + s.getGrade());
			System.out.println("-----------------------");
		}

		Iterator<Student> it = alist.iterator();
		while (it.hasNext()) {
			Student s = it.next();
			System.out.println("이름 : " + s.getName());
			System.out.println("학과 : " + s.getDepartment());
			System.out.println("학번 : " + s.getId());
			System.out.println("학점평균 : " + s.getGrade());
			System.out.println("-----------------------");
		}
	}

	public void search() {
	// answer
		while (true) {
			System.out.println("학생이름을 입력하세요. 종료는 X");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) break;
			Iterator<Student> it = alist.iterator();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getName().equals(name)) {
					System.out.println("이름 : " + s.getName());
					System.out.println("학과 : " + s.getDepartment());
					System.out.println("학번 : " + s.getId());
					System.out.println("학점평균 : " + s.getGrade());
					System.out.println("-----------------------");
				}
			}
		}
	}

	public static void main(String[] args) {
		Mon5_01 mon = new Mon5_01();
		// split을 이용하라.
		// 입력
		mon.insert();

		// 출력
		mon.print();

		// 검색
		mon.search();

	}

}
