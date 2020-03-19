package day05;

public class Exam33 {
	public static void main(String[] args) {
		String[] str; //선언
		str=new String[5]; //생성
		String[] arr=new String[5];
		String st[]=new String[5];
		str[0]="one";
		str[1]="two";
		str[2]="three"; //null : 미정의 값
		str[3]="four";
		str[4]="five";
		for(int i=0; i<str.length; i++) {
			if(str[i]!=null) System.out.println("str"+"["+i+"] = "+str[i]); //한줄에는 중괄호 안써도 된다.
		}
		System.out.println(str[3]);
		System.out.println("==============");
		
		//for-each로 처음부터 끝까지의 값을 모두 표현하자.
		for( String s : str) {
			System.out.println(s);
		}
	}
}