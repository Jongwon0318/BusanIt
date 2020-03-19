package day05;
import java.util.Scanner;

public class Exam32 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for(int i=1; i<6; i++) {
			for(int j=1; j<=i; j++) 	System.out.print(j); //시작점을 생각하자.
			System.out.println();
		}
	
		int [ ] data = {10,5,90,100,250,30,77};
		int max=data[0]; //새로운 정보를 기억하고싶을때는 변수를 설정해라!
		int maxPos=0;
		int sum=0;
		for(int i=0; i<data.length; i++) {
			if(max<data[i]) {
				max=data[i]; // if(max<data[i]) max=data[i]
				maxPos=i+1;
			}
			sum+=data[i];
		}//max=data[4]=250;
		System.out.println("\n"+"최댓값 : "+max+"\n"
											+"최댓값의 위치 : "+maxPos+"번째"+"\n"
											+"배열의 합계 : "+sum+"\n"
											+"배열의 평균 : "+(float)sum/data.length+"\n"//(   )는 뒤의 값을 캐스팅(형변환)시키는 명령어
											+"찾을 숫자를 입력하세요.");
		int find=sc.nextInt();
		int findPos=data.length+1;
		for(int i=0; i<data.length; i++) {
			if (find==data[i]) 	findPos=i;
		}
		if(findPos<=data.length)	System.out.println(find+"값은 배열의 "+(findPos+1)+"번째에 있습니다.");
		if(findPos==data.length+1) System.out.println("찾는 값 "+find+" : 배열 내에 존재하지 않음.");
	} 																	
}