package chap06_2019_11_12;

import java.util.StringTokenizer;

public class StringTok {

	public static void main(String[] args) {
		StringTokenizer st 
		= new StringTokenizer("홍길동/장화/홍련/팥쥐/주인공","/");
		System.out.println(st.countTokens());
//		int len = st.countTokens();
//		for(int i=0; i<len ;i++) {
//			System.out.println(st.nextToken());
//		}
		while(st.hasMoreTokens()) {
			System.out.println(st.countTokens() +":"+ st.nextToken());
		}
		
		StringTokenizer st1 
		= new StringTokenizer("홍길동 장화 홍련 팥쥐 주인공");
		System.out.println(st1.countTokens());
		
		StringTokenizer stk 
		= new StringTokenizer("1 0 14 15 8");
		// stk 를 16진수로 표시하시오
		while(stk.hasMoreTokens()) {
			System.out.print("개수 :" + stk.countTokens()+"\t");
			String token = stk.nextToken(); //1
			String hex = Integer.toHexString(Integer.parseInt(token));
			System.out.println(hex);
		}
	}
}