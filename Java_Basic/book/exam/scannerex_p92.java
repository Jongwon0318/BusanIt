package book.exam;
//실행결과
public class scannerex_p92 {
	public static void main(String[] args) {
		short a=(short)0x55ff;
		short b=(short)0x00ff;
		System.out.println("[비트 연산 결과]");
		System.out.printf("%04x\n", (short)(a&b));
		System.out.printf("%04x\n", (short)(a|b));
		System.out.printf("%04x\n", (short)(a^b));
		System.out.printf("%04x\n", (short)(~a));
	 
		byte c=20; // 0 0 0 1 0 1 0 0
		byte d=-8; // -0 0 0 0 1 0 0 0
		System.out.println("[시프트 연산 결과]");
		System.out.println(c<<2); // 0 1 0 1 0 0 0 0 16+64=80
		System.out.println(c>>2); // 0 0 0 0 0 1 0 1 1+4=5
		System.out.println(d>>2); // -0 0 0 0 0 0 1 0 -2
		System.out.printf("%x\n", (d>>>2));
	}
}