package review_ex2;

public class Encryptor_Decryptor {
	public static String encrypt(String str) {
		String dap ="";
		for(int i=0 ; i<str.length();i++) {//������ �״�� ���
			if(str.charAt(i)==' ') {  //�����̸�
				dap+=str.charAt(i);
			}else {  //������ �ƴϸ� 
				dap+=(char)(str.charAt(i)+2);
			}
		}
		return dap;
	}
	
	public static String decrypt(String str) {
		String dap ="";
		for(int i=0 ; i<str.length();i++) {//������ �״�� ���
			if(str.charAt(i)==' ') {  //�����̸�
				dap+=str.charAt(i);
			}else {  //������ �ƴϸ� 
				dap+=(char)(str.charAt(i)-2);
			}
		}
		return dap;
	}
}