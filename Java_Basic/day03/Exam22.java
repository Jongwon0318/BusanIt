package day03;

public class Exam22 {
	public static void main(String[] args) {
		byte n1 = 13; // 0 0 0 0 1 1 0 1 컴퓨터가 읽는 방법(2진법)
		byte n2 = 7; // 0 0 0 0 0 1 1 1 컴퓨터가 읽는 방법(2진법)
		int n3 = n1&n2; //&&, ||
		//& 둘 다 1일때만 1 -> 0 0 0 0 0 1 0 1
		int n4 = n1|n2;
		//| 둘 중 하나라도 1이면 1-> 0 0 0 0 1 1 1 1
		int n5= n1^n2;
		//^ 두개가 다를때만 1(exclusively work)->0 0 0 0 1 0 1 0
		System.out.println("n3 : "+n3);
		System.out.println("n4 :"+n4);
		System.out.println("n5 :"+n5);
		System.out.println("~n5 :"+~n5);
		//~를 음수표현이라 한다. 0 0 0 0 1 0 1 0의 음수표현 -> 2의 보수를 사용하여 음수표현
		//2의보수 = 1의 보수+1, -1 1 1 1 0 1 0 1(1의 보수) == 0 0 0 0 1 0 1 0 +1
		System.out.println(n1>>1); //6
		//n1>>1 -> 0 0 0 0 1 1 0 1을 오른쪽으로 1자리씩 밀어라 -> 0 0 0 0 0 1 1 0 == 십진수에서 나누기 2를 해라
		System.out.println(n1>>2); //3 십진수에서 나누기 2를 두번 해라.
		System.out.println(n1<<1);// 0 0 0 1 1 0 1 0 ,  십진수 곱하기 2와 같다 >>,<<는 시프트연산이라고 한다.
	}
}