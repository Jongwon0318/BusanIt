package day02;

//조건문 if

public class Exam05 {
	public static void main (String[] args) {
		int a=48;
		System.out.print("a는 ");
		//a가 50보다 큰지 작은지를 알고싶다.
		if(a>50) { //true
			System.out.println("50보다 크다");
		    }else { //false
			System.out.println("50보다 작다");				
			}
	
		//a가 짝수인지 홀수인지 판단해서 출력
			//if((a%2)==0 {
			//System.out.println("짝수이다");
			//}else{
			//System.out.println("홀수이다");
		System.out.print("a는 ");
			if((a%2)>0) { 
			System.out.println("홀수이다.");
		}else {
			System.out.println("짝수이다.");
			}
			/*
			*0미만
			*0에서 100사이 수
			*101에서 200 사이 수
			*201에서 300 사이 수
			*300이상
			*/
			int b=252;
			System.out.print("b는 ");
			if(b<0) { // 다중 if
				System.out.println("b는 0미만"); // if(b<=100)은 무슨 표현인가?
			}else  if(b<100){									// else가 없으면 무조건 방문한다.
				System.out.println("0에서 99 사이 수");
			}else if(b<200) {
				System.out.println("100에서 199 사이 수");
			}else if(b<300) {
				System.out.println("200에서 299 사이 수");
			}else {
				System.out.println("300을 이상의 수");}
				
			int c=152;
			System.out.print("c는 ");
			if(c<0) {
				System.out.println("0보다 작은 수");
			}if(c>0 && c<100) { //0보다 크고 100보다 작다
				System.out.println("0에서 99 사이 수");
			}if(c>=100 && c<200) {
				System.out.println("100에서 199 사이 수");
			}if(c>=200 && c<300) {
				System.out.println("200에서 299 사이 수");
			}else {
				System.out.println("300이상 수");
			}
	}
}