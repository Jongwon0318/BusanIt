package chap06_2019_11_12;

public class StringTest06 {

	public static void main(String[] args) {
		String msg="This is a Java";
		//split() �� �̿��ؼ� Java a is This ���
		String[] arr = msg.split(" "); // arr={"This","is","a","Java"};
		
		for(int i=0; i<2; i++) {
			System.out.print(arr[i]+"  ");
		}
		
		System.out.println();
		
		//Java a is This
		for(int i=arr.length-1; i>=0;i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
						
		//avaJ a si  sihT
		for(int i=arr.length-1; i>=0;i--) {  //Java
			for(int j =arr[i].length()-1; j>=0 ; j--  ) {
				System.out.print(arr[i].charAt(j));
			}
			System.out.print(" ");
		}
		System.out.println();
		
		String[] tmp = msg.split(""); //tmp={"T","h","i","s"," ","i","s"," ","a"," ","J","a","v',"a"};
		for(int i=tmp.length-1;i>=0;i--) {
			System.out.print(tmp[i]);
		}
		System.out.println();
		System.out.println("�迭 tmp�� ���� : "+tmp.length);
		System.out.println("==================");
		String str =  "Hi.. Glad to meet you!!";
		//�ѱ��ھ� �����Ͽ� 2�� ���Ͽ� ���
		System.out.println((char)('a'+2));
		for(int i=0 ; i<str.length();i++) {
			System.out.print((char)(str.charAt(i)+2));
		}
		System.out.println();
		// str�� ������ ����
		System.out.println("str ���������� : "+str.charAt(str.length()-1));
      //meet ����
		System.out.println(str.substring(13, 17));
		System.out.println(str.substring(5));
	}

}




