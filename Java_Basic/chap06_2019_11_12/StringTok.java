package chap06_2019_11_12;

import java.util.StringTokenizer;

public class StringTok {

	public static void main(String[] args) {
		StringTokenizer st 
		= new StringTokenizer("ȫ�浿/��ȭ/ȫ��/����/���ΰ�","/");
		System.out.println(st.countTokens());
//		int len = st.countTokens();
//		for(int i=0; i<len ;i++) {
//			System.out.println(st.nextToken());
//		}
		while(st.hasMoreTokens()) {
			System.out.println(st.countTokens() +":"+ st.nextToken());
		}
		
		StringTokenizer st1 
		= new StringTokenizer("ȫ�浿 ��ȭ ȫ�� ���� ���ΰ�");
		System.out.println(st1.countTokens());
		
		StringTokenizer stk 
		= new StringTokenizer("1 0 14 15 8");
		// stk �� 16������ ǥ���Ͻÿ�
		while(stk.hasMoreTokens()) {
			System.out.print("���� :" + stk.countTokens()+"\t");
			String token = stk.nextToken(); //1
			String hex = Integer.toHexString(Integer.parseInt(token));
			System.out.println(hex);
		}
	}
}