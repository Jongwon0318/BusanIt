package day04;

public class Exam29 {
	public static void main(String[] args) {

	//1~10��, 11~20��, ... �� ���� for������ ǥ��
		int sum=0;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10*i; j+=10) {
				sum+=j;
				System.out.println(j+"����"+(j+9)+"������ �� : "+sum);
				sum=0;
			}
		System.out.println();
		}
	}
}
