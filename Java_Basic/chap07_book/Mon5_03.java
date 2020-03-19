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
			System.out.println("학생이름,학과,학번,학점평균 입력하세요. \n 예) 백종원, 부동산,1,4.0");
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
			System.out.println("이름 : " + s.getName());
			System.out.println("학과 : " + s.getDepartment());
			System.out.println("학번 : " + s.getId());
			System.out.println("학점평균 : " + s.getGrade());
			System.out.println("-----------------------");
		}
		//System.out.println(map);
	}
	
	public void search() {
		while(true) {
			System.out.println("학생이름을 입력하세요. 종료는 X");
			String name = sc.next();
			if (name.toLowerCase().equals("x")) break;
		/*	Set<String> set=map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String key=it.next();
				Student s=map.get(key);
				if(s.getName().equals(name)) {
					System.out.println("-----------------------");
					System.out.println("이름 : " + s.getName());
					System.out.println("학과 : " + s.getDepartment());
					System.out.println("학번 : " + s.getId());
					System.out.println("학점평균 : " + s.getGrade());
					System.out.println("-----------------------");
				}
			} */
			
			if(map.containsKey(name)) {
				Student s=map.get(name);
				System.out.println("-----------------------");
				System.out.println("이름 : " + s.getName());
				System.out.println("학과 : " + s.getDepartment());
				System.out.println("학번 : " + s.getId());
				System.out.println("학점평균 : " + s.getGrade());
				System.out.println("-----------------------");
			}else {
				System.out.println("찾는 학생 없음");
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
