package review_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//1.�ؽ��� hm����.
//1���� 20������ ������ �߻�
//���� 10���� hm�� �߰�. ��, �ߺ� ��� �ȵ�.
//������� �����϶�.

public class HashMapTest02 {
	public static void main(String[] args) {
		HashMap<Integer, Integer> hm=new HashMap<Integer,Integer>();
		for(int i=1; i<11; i++) {
			while(true) {
				int r=(int)((Math.random()*20)+1);
				if(hm.containsValue(r)==false) {
					hm.put(i,r);
					break;
				}
			}
		}
		System.out.println(hm+"\t");

		ArrayList<Integer> list= new ArrayList<Integer>(hm.values());
		Collections.sort(list);
		
	}
}
