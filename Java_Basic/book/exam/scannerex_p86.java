package book.exam;
//연산결과
public class scannerex_p86 {
	public static void main(String[] args) {
		System.out.println('a'>'b'); // x
		System.out.println(3>=2); // x-->o
		System.out.println(-1<0); //o
		System.out.println(3.45<=2); //x
		System.out.println(3==2); //x
		System.out.println(3!=2); //o
		System.out.println(!(3!=2)); //o-->x
		System.out.println((3>2)&&(3>4)); //0-->x
		System.out.println((3!=2)||(3>4)); //0-->o
		System.out.println((3!=2)^(-1>0)); //0-->o ???????????
	}
}