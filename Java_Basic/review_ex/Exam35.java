package review_ex;

public class Exam35 {
	public static void main(String[] args) {
		int[] lotto=new int[7];
		int n=0;
		while(n<lotto.length){
			int r=(int)(Math.random()*44+1);
			lotto[n]=r;
			for(int j=0; j<n; j++) {
				if(lotto[n]==lotto[j]) {
					continue;
				}else {
					n++;
				}
			}
		}
		for(int i=0; i<lotto.length; i++) System.out.println(lotto[i]);
	}
}