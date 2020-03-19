package review_ex2;

public class Encryptor_Decryptor {
	public static String encrypt(String str) {
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
	
	public static String decrypt(String str) {
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
}