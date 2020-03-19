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
			System.out.println("�л� �̸�,�а�,�й�,��������� �Է��ϼ���");
			StudentBean sbn = new StudentBean();
			String str = sc.nextLine();
			// split�� �̿��ؼ� �����ϰ�, map�� ����
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
			System.out.println("------------�л�����------------");
			System.out.println(sb); // Override w/ toString
		}
	}

	public void search() {
		while (true) {
			System.out.println("---------------------------------");
			System.out.println("�̸��� �Է��ϼ���. x�� �Է��ϸ� ����");
			String name = sc.next();
			if (name.toLowerCase().equals("x"))
				break;
			if (map.containsKey(name)) {
				StudentBean sb = map.get(name);
				System.out.println(sb);
			} else {
				System.out.println("---------ã�� �̸� ����---------");
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
