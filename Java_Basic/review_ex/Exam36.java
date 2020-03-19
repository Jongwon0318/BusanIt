package review_ex;

public class Exam36 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		int n=0;
		while(n<arr.length) {
			int r=(int)(Math.random()*50);
			if (r!=0) {
				arr[n]=r;
			}
			else {
				continue;
			}
			System.out.println("arr"+"["+n+"]"+" = "+arr[n]);
			n++;
		}
	}
}