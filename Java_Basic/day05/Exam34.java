package day05;

public class Exam34 {
	public static void main(String[] args) {
		int[][] arr=new int[3][4]; 
		// 앞에 있는게 중괄호가 몇개인가를(row), 뒤에있는게 중괄호 안에 몇개인가(col)를 물어보는 것
		arr[0][0]=1; //arr[2][0]=7;
		int[][] a = {{1,2,3,33},{4,5,6,66},{7,8,9,99},{10,11,12,1122}};
		System.out.println(a); //주소값
		System.out.println(a); //주소값
		System.out.println(a[0][0]); //1
		System.out.println(a.length); //
		System.out.println(a[0].length); //
		System.out.println();
		for(int i=0; i<a.length; i++) { 
			//a.length는 가로줄을 표현한것.
			for(int j=0; j<a[i].length; j++)	System.out.print(a[i][j]+"\t"); 
			//a[i].length는 세로줄을 표현한것.
			System.out.println();
		}
		System.out.println();		
//		int[][] b= new int[4][]; // 4줄인것은 알겠는데, 중괄호안에 몇개가 있는지는 모르겠다.
//		b[0] = new int[3];
//		b[1] = new int[4];
//		b[2] = new int[3];
//		b[3] = new int[2];
		int [][] b= {{10,20,30},{40,50,60,70},{80,90,100},{110,120}};
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) System.out.print(b[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
		double ran=Math.random(); 
		//Math.random(); : 난수생성,0에서 1사이의 double형을 return 해줌
		System.out.println("ran : "+ran);
		//1에서 10사이의 난수구하기???
		int r=(int)((ran*10)+1);
		System.out.println("r : "+r);
	}
}