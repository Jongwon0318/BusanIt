package day04;

public class Exam28answer {
	public static void main(String[] args) {
		for(char i='z'; i>='a'; i--) { //z
			for(char j='a'; j<='z'; j++){ // a b c    z
				if(i>j) {
					System.out.print("*"+"\t");
				}else {
					System.out.print(j+"\t");	//z
				}
			}
			System.out.println();
		}
	}
}