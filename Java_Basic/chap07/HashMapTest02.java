package chap07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HashMapTest02 {
	public static void main(String[] args) {
		// 1.�ؽ��� hm����.
		// 1���� 20������ ������ �߻�
		// ���� 10���� hm�� �߰�. ��, �ߺ� ��� �ȵ�.
//		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
//		while(true) {
//			int r=(int)Math.random()*20+1;
//			for(int i=0; i<10; i++) {
//				hm.put(i,r);
//				if(hm.containsValue(hm.get(i))) {
//					continue;
//				}
//			}
//			if(hm.)
//		}
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 1; i < 11; i++) {
			while (true) {
				int v = (int) (Math.random() * 20) + 1;
				if (!hm.containsValue(v)) { // map�� ������ �߰�
					hm.put(i, v);
					break;
				}
			}
		}
		System.out.println(hm + "\t");

		// value���� ���
		for (Integer i : hm.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();

		System.out.println(hm.values());
		System.out.println();

		List<Integer> list = new ArrayList<Integer>(hm.values());

		Collections.sort(list);
		for (Integer i : list) {
			System.out.print(i + "\t");
		}
		
		System.out.println();
		Collections.reverse(list);
		for (Integer i : list) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("�ִ밪 : "+Collections.max(list));
		System.out.println("�ִ밪 : "+Collections.min(list));
	}
}
