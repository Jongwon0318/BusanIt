package chap07_book;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Mon5_04 {
	Scanner sc = new Scanner(System.in);
	HashMap<String, StudentBean> map = new HashMap<>();

	public void insert() {
		for (int i = 0; i < 2; i++) {
			System.out.println("학생 이름,학과,학번,평균학점을 입력하세요");
			StudentBean sbn = new StudentBean();
			String str = sc.nextLine();
			// split을 이용해서 구분하고, map에 저장
			String[] arr = str.split(",");
			sbn.setName(arr[0]);
			sbn.setDept(arr[1]);
			sbn.setId(arr[2]);
			sbn.setGrade(Double.parseDouble(arr[3]));
			map.put(sbn.getName(), sbn);
		}
	}

	public void print() {
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String key = it.next();
			StudentBean sb = map.get(key);
			System.out.println("------------학생정보------------");
			System.out.println(sb); // Override w/ toString
		}
	}

	public void search() {
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("이름을 입력하세요. x를 입력하면 종료");
			String name = sc.next();
			if (name.toLowerCase().equals("x"))
				break;
			if (map.containsKey(name)) {
				StudentBean sb = map.get(name);
				System.out.println(sb);
			} else {
				System.out.println("---------찾는 이름 없음---------");
			}
		}
	}

	public static void main(String[] args) {
		Mon5_04 test = new Mon5_04();
		test.insert();
		test.print();
		test.search();
	}

}
