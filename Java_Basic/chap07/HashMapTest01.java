package chap07;

import java.util.HashMap;

public class HashMapTest01 {
	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("one", "ù��°");
		hm.put("two","�ι�°");
		hm.put("three", "����°");
		hm.put("four", "�׹�°");
		
		System.out.println(hm); //������ ���׹���
		
		System.out.println("hm ũ�� : "+hm.size());
		
		String value=hm.get("one"); ///"ù��°" Key���� ������ Value���� �˷��ش�
		System.out.println(value);
		
		System.out.println("=================");
		hm.put("one", "ù��°");
		System.out.println(hm);
		System.out.println("hm ũ�� : "+hm.size());
		//Key���� �ߺ��� ���ȵǰ� ������ �������.
		
		hm.put("1", "ù��°");
		System.out.println(hm);
		System.out.println("hm ũ�� : "+hm.size());
		System.out.println("====================");
		
		HashMap<String,String> h=new HashMap<String, String>();
		h.put("1", "ù��°");
		h.put("2", "�ι�°");
		h.put("3", "����°");
		h.put("4", "�׹�°");
		//ù��° �ι�° ����° ������ �°� ��µǵ��� for�� �ۼ�
		
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
		//Ű���� ����ϱ�
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
		System.out.println(h.containsValue("����°"));
	}
}
