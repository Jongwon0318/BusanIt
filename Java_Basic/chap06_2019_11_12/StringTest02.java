package chap06_2019_11_12;

public class StringTest02 {

	public static void main(String[] args) {
		String str="�ȳ��ϼ���  Hello ������ �ڹٰ���!!!";
		System.out.println("str ���� : "+str.length());
		System.out.println("H��ġ : "+str.indexOf('H'));
		System.out.println("H��ġ : "+str.indexOf("Hello"));
		System.out.println("4��° ����: "+str.charAt(4));
		String tmp = "������ �սô�.";
		System.out.println("str ��  tmp ����:"+str.concat(tmp) );
		System.out.println("str ��  tmp ����:"+str+tmp );
		int value=7;
		System.out.println("str ��  value ����:"+str+value );
		System.out.println(value);
		String s =String.valueOf(value);  //String = int       String =???(int)
	    System.out.println(s);
	    // tmp��  value ���� concat �� �̿��ؼ� �����ϰ� ���
	  System.out.println(tmp.concat(String.valueOf(value)));
	}

}





