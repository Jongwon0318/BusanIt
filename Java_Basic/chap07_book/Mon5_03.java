package chap07_book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Mon5_03 {
	Scanner sc=new Scanner(System.in);
	HashMap<String,Student> map = new HashMap<>();
	
	public void insert() {
		for(int i=0; i<2; i++) {
			Student stu=new Student();
			System.out.println("�л��̸�,�а�,�й�,������� �Է��ϼ���. \n ��) ������, �ε���,1,4.0");
			String str=sc.nextLine();
			StringTokenizer stk=new StringTokenizer(str,",");
			stu.setName(stk.nextToken());
			stu.setDepartment(stk.nextToken());
			stu.setId(stk.nextToken());
			stu.setGrade(Double.parseDouble(stk.nextToken()));
			map.put(stu.getName(),stu);
		}
	}
	
	public void print() {
		System.out.println("-------------");
		Set<String> set=map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Student s=map.get(key);
			System.out.println("�̸� : " + s.getName());
			System.out.println("�а� : " + s.getDepartment());
			System.out.println("�й� : " + s.getId());
			System.out.println("������� : " + s.getGrade());
			System.out.println("-----------------------");
		}
		//System.out.println(map);
	}
	
	public void search() {
		while(true) {
			System.out.println("�л��̸��� �Է��ϼ���. ����� X");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) break;
		/*	Set<String> set=map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String key=it.next();
				Student s=map.get(key);
				if(s.getName().equals(name)) {
					System.out.println("-----------------------");
					System.out.println("�̸� : " + s.getName());
					System.out.println("�а� : " + s.getDepartment());
					System.out.println("�й� : " + s.getId());
					System.out.println("������� : " + s.getGrade());
					System.out.println("-----------------------");
				}
			} */
			
			if(map.containsKey(name)) {
				Student s=map.get(name);
				System.out.println("-----------------------");
				System.out.println("�̸� : " + s.getName());
				System.out.println("�а� : " + s.getDepartment());
				System.out.println("�й� : " + s.getId());
				System.out.println("������� : " + s.getGrade());
				System.out.println("-----------------------");
			}else {
				System.out.println("ã�� �л� ����");
			}
			
			//if(map.get(name)==null){}
			
			//Student s=map.get(name);
			//if(s!=null){}
			
		}
	}
	
	public static void main(String[] args) {
		Mon5_03 mtest=new Mon5_03();
		mtest.insert();
		mtest.print();
		mtest.search();
	}

}
