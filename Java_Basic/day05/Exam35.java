package day05;

public class Exam35 {
	public static void main(String[] args) {
		//(int)(Math.random()*45)+1
		int[] lotto=new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i]=(int)((Math.random())*44)+1;
			if(lotto[i]==lotto[i-1]) lotto[i]=(int)((Math.random())*44)+1;
		}
		for(int j=0; j<lotto.length; j++) System.out.println(j+"¹ø¤Š ¹øÈ£ : "+lotto[j]);
	}
}