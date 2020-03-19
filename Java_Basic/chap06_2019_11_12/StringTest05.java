package chap06_2019_11_12;

public class StringTest05 {

	public static void main(String[] args) {
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		//split() �� �̿��ؼ� �迭�� �ִ´�
		String[] arr = tmp.split(" ");
		// 2����, 8����, 16������ ���� ��ȯ�Ͽ� ����Ͻÿ�
		String bin ="";  // 2���� ��� 
		String oct = ""; // 8���� ��� 
		String hex =""; // 16���� ��� 
		for(String s : arr) { 
			int num = Integer.parseInt(s);
			bin += Integer.toBinaryString(num) +"\t";
			oct += Integer.toOctalString(num) +"\t";
			hex += Integer.toHexString(num)+"\t";
		}
	  System.out.println("2���� : "+bin);
	  System.out.println("8���� : "+oct);
	  System.out.println("16���� : "+hex);

	}

}
