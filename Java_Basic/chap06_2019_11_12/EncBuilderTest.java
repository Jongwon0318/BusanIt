package chap06_2019_11_12;

public class EncBuilderTest {
	private StringBuilder encrypt(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length();i++) {//������ �״�� ���
			if(str.charAt(i)==' ') {  //�����̸�
				sb.append(str.charAt(i));
			}else {  //������ �ƴϸ� 
				sb.append((char)(str.charAt(i)+2));
				}
		}
		return sb;
	}
	private StringBuilder decrypt(String  str) {
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<str.length();i++) {//������ �״�� ���
			if(str.charAt(i)==' ') {  //�����̸�
				sb.append(str.charAt(i));
			}else {  //������ �ƴϸ� 
				sb.append((char)(str.charAt(i)-2));
			}
		}
		return sb;
	}
	public static void main(String[] args) {
		EncBuilderTest eb = new EncBuilderTest();
		String msg = "Hi.. Glad to meet you!!";
		System.out.println("��ȣȭ �� : " + msg);
		String str1=eb.encrypt(msg).toString(); //�ѹ��ڿ� 2�� ���ϱ�
		System.out.println("��ȣȭ �� : " + str1);
		System.out.println("��ȣȭ �� : " + eb.decrypt(str1));//��ȣȭ �� �ſ��� -2
	}
}
