package day05;

public class Exam33 {
	public static void main(String[] args) {
		String[] str; //����
		str=new String[5]; //����
		String[] arr=new String[5];
		String st[]=new String[5];
		str[0]="one";
		str[1]="two";
		str[2]="three"; //null : ������ ��
		str[3]="four";
		str[4]="five";
		for(int i=0; i<str.length; i++) {
			if(str[i]!=null) System.out.println("str"+"["+i+"] = "+str[i]); //���ٿ��� �߰�ȣ �Ƚᵵ �ȴ�.
		}
		System.out.println(str[3]);
		System.out.println("==============");
		
		//for-each�� ó������ �������� ���� ��� ǥ������.
		for( String s : str) {
			System.out.println(s);
		}
	}
}