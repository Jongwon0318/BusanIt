package chap07_book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mon5_02 {
	Scanner sc=new Scanner(System.in);
	ArrayList<Student> alist=new ArrayList<>();
	
	public void insert() {
		//StringTokenizer�� �̿��ؼ� ,�� ����
		for(int i=0; i<2; i++) {
			Student stu=new Student();
			System.out.println("�л��̸�,�а�,�й�,������� �Է��ϼ���. \n ��) ������, �ε���,1,4.0");
			String str=sc.nextLine();
			StringTokenizer stk=new StringTokenizer(str,",");
			stu.setName(stk.nextToken());
			stu.setDepartment(stk.nextToken());
			stu.setId(stk.nextToken());
			stu.setGrade(Double.parseDouble(stk.nextToken()));
			alist.add(stu);
		}
	}
	public void print() {
		System.out.println("-----------------------");
		for (Student s : alist) {
			System.out.println("�̸� : " + s.getName());
			System.out.println("�а� : " + s.getDepartment());
			System.out.println("�й� : " + s.getId());
			System.out.println("������� : " + s.getGrade());
			System.out.println("-----------------------");
		}
	}
	public void search() {
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
		Mon5_02 mtest=new Mon5_02();
		mtest.insert();
		mtest.print();
		mtest.search();
	}

}
