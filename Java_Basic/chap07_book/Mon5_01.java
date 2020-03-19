package chap07_book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
	// �̸�,�а�,�й�,�������
	private String name;
	private String department;
	private String id;
	private double grade;

	// getter,setter ���ϰ� �����
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
			System.out.println("�л��̸�,�а�,�й�,������� �Է��ϼ���. \n ��) ������, �ε���,1,4.0");
					//Ȳ����,�����,1,4.1 ���繮,�ȵ���̵�,2,3.9 �賲��,������,3,3.5 ������,������,4,4.25
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
		//3���� ��� �� ����
		
		for (int i = 0; i <alist.size(); i++) {
			System.out.println("�̸� : " + alist.get(i).getName());
			System.out.println("�а� : " + alist.get(i).getDepartment());
			System.out.println("�й� : " + alist.get(i).getId());
			System.out.println("������� : " + alist.get(i).getGrade());
			System.out.println("-----------------------");
		}

		for (Student s : alist) {
			System.out.println("�̸� : " + s.getName());
			System.out.println("�а� : " + s.getDepartment());
			System.out.println("�й� : " + s.getId());
			System.out.println("������� : " + s.getGrade());
			System.out.println("-----------------------");
		}

		Iterator<Student> it = alist.iterator();
		while (it.hasNext()) {
			Student s = it.next();
			System.out.println("�̸� : " + s.getName());
			System.out.println("�а� : " + s.getDepartment());
			System.out.println("�й� : " + s.getId());
			System.out.println("������� : " + s.getGrade());
			System.out.println("-----------------------");
		}
	}

	public void search() {
	// answer
		while (true) {
			System.out.println("�л��̸��� �Է��ϼ���. ����� X");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) break;
			Iterator<Student> it = alist.iterator();
			while (it.hasNext()) {
				Student s = it.next();
				if (s.getName().equals(name)) {
					System.out.println("�̸� : " + s.getName());
					System.out.println("�а� : " + s.getDepartment());
					System.out.println("�й� : " + s.getId());
					System.out.println("������� : " + s.getGrade());
					System.out.println("-----------------------");
				}
			}
		}
	}

	public static void main(String[] args) {
		Mon5_01 mon = new Mon5_01();
		// split�� �̿��϶�.
		// �Է�
		mon.insert();

		// ���
		mon.print();

		// �˻�
		mon.search();

	}

}
