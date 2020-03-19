package review_ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//1.해쉬맵 hm생성.
//1에서 20사이의 난수를 발생
//난수 10개를 hm에 추가. 단, 중복 허용 안됨.
//순서대로 정렬하라.

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
