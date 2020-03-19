package chap06_2019_11_12;

public class SayHello {

	public static void main(String[] args) {
		String[] msg =  {"안녕하세요", "Hi","Hello","잘자","안녕"};
		//10번의 인사말 출력
		try {
			for(int i=0 ; i <10; i++) {
				int num = (int)(Math.random()*10);
				System.out.println(num +" : " + msg[num]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}
		System.out.println("=================");
	   for(int i=0; i<10; i++) {
			int num = (int)(Math.random()*10);
			try {
				System.out.println(num +" : " + msg[num]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 범위 초과");
			}
	   }
	

	}

}
