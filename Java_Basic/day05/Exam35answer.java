package day05;

public class Exam35answer {
	public static void main(String[] args) {
		int [] lotto=new int[6];
		int n=0;
		while(n<lotto.length) {
			int r=(int)(Math.random()*44)+1; //30 40
			lotto[n]=r; //0
			for(int i=0; i<n; i++) { //0
				if(r==lotto[i]) {//중복발생
					n--;
					break;
				}
			}
			n++;
		}
		for(int i=0; i<lotto.length; i++) System.out.println((i+1)+"번째 "+"로또번호 : "+lotto[i]+"\n");
	}
}