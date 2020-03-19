package day05;

public class Exam37 {
	public static void main(String[] args) {
		int[][] a= new int[4][4];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j]=0;
			}
		}
		int n=0;
		int m=0;
		while(n<4) {
			int r=(int)((Math.random()*5));
			n=r;
			while(m<4) {
				int s=(int)((Math.random()*5));
				m=s;
				if(a[n][m]==0) {
					int t=(int)((Math.random())*10+1);
					a[n][m]=t;
				}
			}
		}
		for(int i=0; i<4; i++) {
			for(int j=0; i<4; j++) {
				System.out.println(a[i][j]);
			}
		}
	}
}