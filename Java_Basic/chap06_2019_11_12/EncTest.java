package chap06_2019_11_12;

public class EncTest {
	public String encrypt(String str) {
		String dap ="";
		for(int i=0 ; i<str.length();i++) {//공백은 그대로 출력
			if(str.charAt(i)==' ') {  //공백이면
				dap+=str.charAt(i);
			}else {  //공백이 아니면 
				dap+=(char)(str.charAt(i)+2);
			}
		}
		return dap;
	}
	
	public String decrypt(String str) {
		String dap ="";
		for(int i=0 ; i<str.length();i++) {//공백은 그대로 출력
			if(str.charAt(i)==' ') {  //공백이면
				dap+=str.charAt(i);
			}else {  //공백이 아니면 
				dap+=(char)(str.charAt(i)-2);
			}
		}
		return dap;
	}

	public static void main(String[] args) {
		EncTest enc = new EncTest();
		String msg = "Hi.. Glad to meet you!!";
		System.out.println("암호화 전 : " + msg);
		String str1=enc.encrypt(msg); //한문자에 2씩 더하기
		System.out.println("암호화 후 : " + str1);
	    System.out.println("복호화 후 : " + enc.decrypt(str1));//암호화 된 거에다 -2
	}

}
