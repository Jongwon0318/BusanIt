package chap07_book;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mon5_02 {
	Scanner sc=new Scanner(System.in);
	ArrayList<Student> alist=new ArrayList<>();
	
	public void insert() {
		//StringTokenizer를 이용해서 ,로 구분
		for(int i=0; i<2; i++) {
			Student stu=new Student();
			System.out.println("학생이름,학과,학번,학점평균 입력하세요. \n 예) 백종원, 부동산,1,4.0");
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
			System.out.println("이름 : " + s.getName());
			System.out.println("학과 : " + s.getDepartment());
			System.out.println("학번 : " + s.getId());
			System.out.println("학점평균 : " + s.getGrade());
			System.out.println("-----------------------");
		}
	}
	public void search() {
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
		Mon5_02 mtest=new Mon5_02();
		mtest.insert();
		mtest.print();
		mtest.search();
	}

}
