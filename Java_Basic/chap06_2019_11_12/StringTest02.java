package chap06_2019_11_12;

public class StringTest02 {

	public static void main(String[] args) {
		String str="안녕하세요  Hello 지금은 자바공부!!!";
		System.out.println("str 길이 : "+str.length());
		System.out.println("H위치 : "+str.indexOf('H'));
		System.out.println("H위치 : "+str.indexOf("Hello"));
		System.out.println("4번째 문자: "+str.charAt(4));
		String tmp = "열심히 합시다.";
		System.out.println("str 과  tmp 연결:"+str.concat(tmp) );
		System.out.println("str 과  tmp 연결:"+str+tmp );
		int value=7;
		System.out.println("str 과  value 연결:"+str+value );
		System.out.println(value);
		String s =String.valueOf(value);  //String = int       String =???(int)
	    System.out.println(s);
	    // tmp와  value 값을 concat 을 이용해서 연결하고 출력
	  System.out.println(tmp.concat(String.valueOf(value)));
	}

}





