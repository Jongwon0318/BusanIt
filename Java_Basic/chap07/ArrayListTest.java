package chap07;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		//배열
				int[] arr=new int[5];
				arr[0]=1; arr[1]=2;
		
		ArrayList alist=new ArrayList();
		alist.add("one");
		alist.add(1); //Integer형 , 오류가 나지 않는 이유->래퍼클래스..
		alist.add("two");
		alist.add(2);
		System.out.println("alist 크기 : "+alist.size());
		alist.add("three");
		alist.add(new Integer(3));
		System.out.println("alist 크기 : "+alist.size());
		System.out.println("two : "+alist.get(2));
		System.out.println("마지막 : "+alist.get(alist.size()-1));
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
		//for-each
		for(Object obj : alist){ //Object가 최상위 객체이기때문에 이렇게 표현. get을 불러오는것보다 편함
			System.out.println(obj);
		}
		System.out.println("============");
		//3번째 딸기
		System.out.println("딸기 추가하기");
		alist.add(2, "딸기"); // index는 0 , 1 , 2 ... 형태, 즉 0부터 시작함.
		for(Object obj : alist){ //Object가 최상위 객체이기때문에 이렇게 표현. get을 불러오는것보다 편함
			System.out.println(obj);
		}
		
		//0번째 삭제
		System.out.println("==============");
		alist.remove(0);
		for(Object obj : alist){ //Object가 최상위 객체이기때문에 이렇게 표현. get을 불러오는것보다 편함
			System.out.println(obj);
		}
		System.out.println("딸기 삭제 후");
		alist.remove("딸기");
		for(Object obj : alist){ //Object가 최상위 객체이기때문에 이렇게 표현. get을 불러오는것보다 편함
			System.out.println(obj);
		}
		System.out.println("==============");
		//제네릭
		ArrayList<String> blist = new ArrayList<String>(); // 뒤의 <String>은 지워도 됨
		//blist.add(1); -> Integer형을 추가할 수 없음.
		blist.add("1");
		blist.add("바나나");
		for(String s:blist) {
			System.out.println(s);
		}
		for(int i=0; i<blist.size(); i++) {
			System.out.println(blist.get(i));
		}
	}
}