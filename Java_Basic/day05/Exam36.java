package day05;

public class Exam36 {
	public static void main(String[] args) {
		int[] arr=new int[10];
		int n=0;
		while(n<arr.length) {
			int r=(int)(Math.random()*50);
			if(r==0);  //continue�� ����Ҽ��� ����.
			else {
				arr[n]=r;
				n++;}
		}
		for(int i=0; i<arr.length; i++) System.out.println("�迭 ���� "+(i+1)+"��° �� : "+arr[i]);
	}
}