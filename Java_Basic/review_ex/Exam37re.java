package review_ex;

public class Exam37re {
	public static void main(String[] args) {
		int[][] arr=new int[4][4];
		int n=0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j]=0;
			}
		}
		
		while(n<=16) {
			int row=(int)(Math.random()*4);
			int cul=(int)(Math.random()*4);

			if(arr[row][cul]==0) {
				int t =(int)(Math.random()*10+1);
				arr[row][cul]=t;
				n++;
			}else {
				if(n==16) break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
