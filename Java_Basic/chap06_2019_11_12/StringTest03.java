package chap06_2019_11_12;

public class StringTest03 {

	public static void main(String[] args) {
	String tmp="1 0 15 23 6 21 17 10 11 12 13 14";
	//tmp����
	System.out.println("tmp���� : " + tmp.length());
	String[] arr = tmp.split(" "); 
	System.out.println("arr ���� : " + arr.length);
	for(int i = 0; i<arr.length;i++) {
		System.out.print(arr[i] +"\t");  // 1 0 15 23 6 21 17 10 11 12 13 14
	}
	System.out.println();
	System.out.println("---16���� ------");
	for(int i=0 ;i<arr.length;i++) {
		//���ڿ��� int �� �ٲ�� ��.
		int v = Integer.parseInt(arr[i]);
		System.out.print(Integer.toHexString(v).toUpperCase() +"\t");
	}
	System.out.println();
	String str = "Hello java";
	System.out.println("�빮�ڷ� : " + str.toUpperCase());
	System.out.println("�ҹ��ڷ� : " + str.toLowerCase());
	
	
	
	
 }

}
