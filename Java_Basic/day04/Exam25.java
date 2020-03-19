package day04;

public class Exam25 {
	public static void main(String[] args) {
		for(int i=2; i<=4; i++) {
			for(int j=1; j<=3; j++) {
				System.out.print(i+"*"+j+" = "+i*j+"\t");
			}System.out.println();
		}
	}
}
//이중for문 : 바깥쪽에서 한번돌때 안쪽을 다 돌고나서 다시 바깥족을 돈다.