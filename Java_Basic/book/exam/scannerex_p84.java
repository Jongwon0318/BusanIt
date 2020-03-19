package book.exam;
//실행결과
public class scannerex_p84 {
 public static void main(String[] args) {
	 int a=3, b=3, c=3;
	 a+=3; //6
	 b*=3; //9
	 c%=2; // 3/2 : 틀림--> 3을 2로나눈 나머지는 1, c/=2 = 3/2
	 System.out.println("a="+a+", b="+b+", c="+c);
	 int d=3;
	 a = d++;
	 System.out.println("a="+a+", d="+d); // a=3, d=4
	 a = ++d;
	 System.out.println("a="+a+", d="+d); // a=5, d=5
	 a = d--;
	 System.out.println("a="+a+", d="+d);// a=4, d=5 : 틀림 -->a=5, d=4
	 a = --d;
	 System.out.println("a="+a+", d="+d);// a=3, d=4 : 틀림 -->a=3, d=3
 }
}
