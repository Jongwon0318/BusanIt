package chap06_2019_11_12;

public class StringTest04 {

	public static void main(String[] args) {
	int a=15;
	// a값을 16진수로 출력 ->대문자
	System.out.println(Integer.toHexString(a).toUpperCase());
	String b = "14";
	//b값을 16진수로 출력
	int v = Integer.parseInt(b);
	System.out.println(Integer.toHexString(v));
	System.out.println(Integer.toHexString(Integer.parseInt(b)));
	}

}
