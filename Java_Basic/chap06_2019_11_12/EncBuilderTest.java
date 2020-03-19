package chap06_2019_11_12;

public class EncBuilderTest {
	private StringBuilder encrypt(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length();i++) {//공백은 그대로 출력
			if(str.charAt(i)==' ') {  //공백이면
				sb.append(str.charAt(i));
			}else {  //공백이 아니면 
				sb.append((char)(str.charAt(i)+2));
				}
		}
		return sb;
	}
	private StringBuilder decrypt(String  str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length();i++) {//공백은 그대로 출력
			if(str.charAt(i)==' ') {  //공백이면
				sb.append(str.charAt(i));
			}else {  //공백이 아니면 
				sb.append((char)(str.charAt(i)-2));
			}
		}
		return sb;
	}
	public static void main(String[] args) {
		EncBuilderTest eb = new EncBuilderTest();
		String msg = "Hi.. Glad to meet you!!";
		System.out.println("암호화 전 : " + msg);
		String str1=eb.encrypt(msg).toString(); //한문자에 2씩 더하기
		System.out.println("암호화 후 : " + str1);
		System.out.println("복호화 후 : " + eb.decrypt(str1));//암호화 된 거에다 -2
	}
}
