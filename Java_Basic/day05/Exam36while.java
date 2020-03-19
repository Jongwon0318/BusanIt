package day05;

public class Exam36while {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int n=0;
		while(n<10) {
			int r=(int)((Math.random())*50);
			if(r==0) {
				continue;
			}else {
				arr[n]=r;
				n++;
			}
		}
		for(int i=0; i<10; i++) System.out.println(arr[i]+"\t");
	}
}