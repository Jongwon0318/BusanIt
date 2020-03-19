package day05;

public class Exam36continue {
	public static void main(String[] args) {
		int[] arr=new int[10];
		int n=0;
		while(n<arr.length) {
			int r=(int)(Math.random()*50);
			if(r==0) continue;
			else {
				arr[n]=r;
				n++;
			}
		}
		for(int i=0; i<arr.length; i++) System.out.println("배열의 "+(i+1)+"번째 수는 : "+arr[i]);
		for( int s : arr) {
			System.out.println(s);
		}
	}
}