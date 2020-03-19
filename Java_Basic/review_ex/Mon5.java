package review_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

class StudentBean{
	private String name;
	private String department;
	private String id;
	private double grade;
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
	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", department=" + department + ", id=" + id + ", grade=" + grade + "]";
	}
	
}
class Student {
	private String name;
	private String department;
	private String id;
	private double grade;

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

public class Mon5 {
	Scanner sc = new Scanner(System.in);
	HashMap<String,StudentBean> alist=new HashMap<>();

	public void insert() {
		for (int i = 0; i < 2; i++) {
			StudentBean st = new StudentBean();
			System.out.println("�̸�,�а�,�й�,��������� �Է��ϼ���.");
			String str = sc.nextLine();
			StringTokenizer stk=new StringTokenizer(str,",");
			st.setName(stk.nextToken());
			st.setDepartment(stk.nextToken());
			st.setId(stk.nextToken());
			st.setGrade(Double.parseDouble(stk.nextToken()));
			alist.put(st.getName(),st);
		}

	}

	public void print() {
		System.out.println("---------�л�����---------");
		Set<String> keys=alist.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key=it.next();
			StudentBean s = alist.get(key);
			System.out.println(s);
			System.out.println("-------------------------");
		}
	}

	public void search() {
		while (true) {
			System.out.println("ã������ �л� �̸��� �Է��ϼ���. x�� �Է��ϸ� ����˴ϴ�.");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) {
				System.out.println("����");
				break;
			}
			Set<String> keys=alist.keySet();
			Iterator<String> it = keys.iterator();
			while(it.hasNext()) {
				String key=it.next();
				StudentBean s = alist.get(key);
				if(s.getName().equals(name)) {
					System.out.println(s);
					System.out.println("-------------------------");
				}
			}
	}
	}
	public static void main(String[] args) {
		Mon5 mon = new Mon5();
		// �Է�
		mon.insert();
		// ���
		mon.print();
		// �˻�
		mon.search();
	}
}
