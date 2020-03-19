package day04;

//배열 : 같은 자료형을 잡아두는 것, 크기를 고정해야한다.
public class Exam30_Array {
	public static void main(String[ ] agrs) {
		int[] arr=new int[5]; //중요하다! 0 1 2 3 4 의 다섯개 방, 
		System.out.println(arr);
		System.out.println(arr[0]); //int의 초기값은 0이다.
		arr[0]=100;
		System.out.println(arr[0]);
		//arr[0]="Java"; 불가능
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;
		arr[4]=500;
		//arr[5]=600;
		for(int i=0; i<arr.length; i++) { //length 중요!! 
			System.out.println(arr[i]);
		}
		int[] arr2 = {1,2,3,4,5,6,7}; //????????
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		/*
		 * int[] arr2 = new int[7];
		 * arr2[0]=1;
		 * arr2[1]=2;
		 * arr2[2]=3;
		 * arr2[3]=4;
		 * arr2[4]=5;
		 * arr2[5]=6;
		 * arr2[6]=7;
		 * */
		 String[] str= {"one","two","three","four"};
		 for(int i=0; i<str.length; i++) {
			 System.out.println(str[i]);
		 }
	}
}

/*	about 자바의 자료형...
*자바의 참조(레퍼런스)형(주소값) : 배열 클래스 인터페이스
* : 자바의 기본 데이터형(값을가짐) 8가지 : char byte int long  float double boolean short 
*/