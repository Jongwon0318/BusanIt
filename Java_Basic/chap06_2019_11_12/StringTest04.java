package chap06_2019_11_12;

public class StringTest04 {

	public static void main(String[] args) {
	int a=15;
	// a���� 16������ ��� ->�빮��
	System.out.println(Integer.toHexString(a).toUpperCase());
	String b = "14";
	//b���� 16������ ���
	int v = Integer.parseInt(b);
	System.out.println(Integer.toHexString(v));
	System.out.println(Integer.toHexString(Integer.parseInt(b)));
	}

}
