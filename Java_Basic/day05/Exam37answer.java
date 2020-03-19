package day05;

public class Exam37answer {
	public static void main(String[] args) {
		int[][] a= new int[4][4];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j]=0;
			}
		}
		int n=0;
		while(n<16) {
			int row=(int)(Math.random()*4);
			int col=(int)(Math.random()*4);
			System.out.println("(row, col)="+row +","+col);
			if(a[row][col]!=0)	continue;
			else {
				a[row][col]=(int)(Math.random()*10)+1;
				n++;
			}
		}
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) System.out.print(a[i][j]+"\t");
			System.out.println();
		}
	}
}