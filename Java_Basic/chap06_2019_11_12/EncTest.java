package chap06_2019_11_12;

public class EncTest {
	public String encrypt(String str) {
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
	
	public String decrypt(String str) {
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

	public static void main(String[] args) {
		EncTest enc = new EncTest();
		String msg = "Hi.. Glad to meet you!!";
		System.out.println("��ȣȭ �� : " + msg);
		String str1=enc.encrypt(msg); //�ѹ��ڿ� 2�� ���ϱ�
		System.out.println("��ȣȭ �� : " + str1);
	    System.out.println("��ȣȭ �� : " + enc.decrypt(str1));//��ȣȭ �� �ſ��� -2
	}

}
