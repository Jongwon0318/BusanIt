package review_ex;

public class Exam30_Array {
	public static void main(String[] args) {
		int[] arr=new int[5];
		System.out.println(arr[0]);
		arr[0]=100;
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;
		arr[4]=500;
		//arr[5]=600; 존재하지않음.
		for(int i=0; i<arr.length; i++) System.out.println(arr[i]);
		
		int[] arr2= {1,2,3,4,5,6,7};
		for(int i=0; i<arr2.length; i++) System.out.println(arr2[i]);
		
		String[] str= {"one","two","three","four"};
		for(int i=0; i<str.length; i++) System.out.println(str[i]);
	}
}