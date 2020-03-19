package chap07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {

	public static void main(String[] args) {
		HashMap<String, Integer> scoreMap=new HashMap<>();
		
		scoreMap.put("김성동", 97);
		scoreMap.put("황기태", 88);
		
		System.out.println("HashMapSize : "+scoreMap.size());
		
		Set<String> keys=scoreMap.keySet();
		Iterator<String> it=keys.iterator();
		
		while(it.hasNext()) {
			String name=it.next();
			int score=scoreMap.get(name);
			System.out.println(name+" : "+score);
		}
	}
}