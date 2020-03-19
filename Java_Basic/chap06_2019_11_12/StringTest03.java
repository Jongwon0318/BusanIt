package chap06_2019_11_12;

public class StringTest03 {

	public static void main(String[] args) {
	String tmp="1 0 15 23 6 21 17 10 11 12 13 14";
	//tmp길이
	System.out.println("tmp길이 : " + tmp.length());
	String[] arr = tmp.split(" "); 
	System.out.println("arr 길이 : " + arr.length);
	for(int i = 0; i<arr.length;i++) {
		System.out.print(arr[i] +"\t");  // 1 0 15 23 6 21 17 10 11 12 13 14
	}
	System.out.println();
	System.out.println("---16진수 ------");
	for(int i=0 ;i<arr.length;i++) {
		//문자열을 int 로 바꿔야 함.
		int v = Integer.parseInt(arr[i]);
		System.out.print(Integer.toHexString(v).toUpperCase() +"\t");
	}
	System.out.println();
	String str = "Hello java";
	System.out.println("대문자로 : " + str.toUpperCase());
	System.out.println("소문자로 : " + str.toLowerCase());
	
	
	
	
 }

}
