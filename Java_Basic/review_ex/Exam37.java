package review_ex;

public class Exam37 { //틀림, 다시 생각해볼 것
	public static void main(String[] args) {
		int[][] arr=new int[4][4];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=0;
			}
		}
		int n=0;
		while(n<16) {
			int row=(int)(Math.random()*4);
			int col=(int)(Math.random()*4);
			System.out.println("(row, col)="+row +","+col);
			if(arr[row][col]!=0)	continue;
			else {
				arr[row][col]=(int)(Math.random()*10)+1;
				n++;
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) 	System.out.print(arr[i][j]+"\t");
			System.out.println();
		}
	}
}