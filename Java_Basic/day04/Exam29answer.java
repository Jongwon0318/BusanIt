package day04;

public class Exam29answer {
	public static void main(String[] args) {
		int sum=0;
		for(int i=1; i<=100 ; i+=10) { //1     11                     21
			for(int j=i; j<(i+10); j++) { //1���� 10����, 11���� 20����, 21���� 30����
				sum+=j;
			}
			System.out.println(i+"���� "+(i+9)+"������ ���� : "+sum);
			sum=0;
		}
	}
}