package chap07;

import java.util.HashMap;

public class HashMapTest01 {
	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("one", "첫번째");
		hm.put("two","두번째");
		hm.put("three", "세번째");
		hm.put("four", "네번째");
		
		System.out.println(hm); //순서는 뒤죽박죽
		
		System.out.println("hm 크기 : "+hm.size());
		
		String value=hm.get("one"); ///"첫번째" Key값을 넣으면 Value값을 알려준다
		System.out.println(value);
		
		System.out.println("=================");
		hm.put("one", "첫번째");
		System.out.println(hm);
		System.out.println("hm 크기 : "+hm.size());
		//Key값의 중복은 허용안되고 순서는 상관없다.
		
		hm.put("1", "첫번째");
		System.out.println(hm);
		System.out.println("hm 크기 : "+hm.size());
		System.out.println("====================");
		
		HashMap<String,String> h=new HashMap<String, String>();
		h.put("1", "첫번째");
		h.put("2", "두번째");
		h.put("3", "세번째");
		h.put("4", "네번째");
		//첫번째 두번째 세번째 순서에 맞게 출력되도록 for문 작성
		
////		for(int i=0; i<h.size(); i++) {
////			if(Integer.parseInt(h.get(i))==1) {
////				System.out.println(h+"\t");
////			}else if(Integer.parseInt(h.get(i))==2) {
////				System.out.println(h+"\t");
////			}else if(Integer.parseInt(h.get(i))==3) {
////				System.out.println(h+"\t");
////			}else {
////				System.out.println(h+"\t");
////			}
//		}
		for(int i=1; i<=h.size(); i++) {
			System.out.println(h.get(String.valueOf(i)));
		}
		System.out.println("============");
		
		for(int i=1; i<=h.size(); i++) {
			System.out.println(h.get(i+""));
		}
		//키값만 출력하기
		for(String s : h.keySet()) {
			System.out.println(s);
		}
		
		for(String s : h.keySet()) {
			System.out.println(h.get(s));
		}
		
		System.out.println("==========");
		
		for(String str : h.values()) {
			System.out.println(str);
		}
		
		System.out.println(h.keySet());
						
		System.out.println(h.containsKey("1"));
		System.out.println(h.containsValue("세번째"));
	}
}
