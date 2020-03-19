package chap06_2019_11_12;

public class StringTest05 {

	public static void main(String[] args) {
		String tmp = "1 0 15 23 6 21 17 10 11 12 13 14";
		//split() 을 이용해서 배열에 넣는다
		String[] arr = tmp.split(" ");
		// 2진수, 8진수, 16진수로 각각 변환하여 출력하시오
		String bin ="";  // 2진수 결과 
		String oct = ""; // 8진수 결과 
		String hex =""; // 16진수 결과 
		for(String s : arr) { 
			int num = Integer.parseInt(s);
			bin += Integer.toBinaryString(num) +"\t";
			oct += Integer.toOctalString(num) +"\t";
			hex += Integer.toHexString(num)+"\t";
		}
	  System.out.println("2진수 : "+bin);
	  System.out.println("8진수 : "+oct);
	  System.out.println("16진수 : "+hex);

	}

}
