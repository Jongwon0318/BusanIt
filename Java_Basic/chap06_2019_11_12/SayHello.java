package chap06_2019_11_12;

public class SayHello {

	public static void main(String[] args) {
		String[] msg =  {"�ȳ��ϼ���", "Hi","Hello","����","�ȳ�"};
		//10���� �λ縻 ���
		try {
			for(int i=0 ; i <10; i++) {
				int num = (int)(Math.random()*10);
				System.out.println(num +" : " + msg[num]);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("�迭 ���� �ʰ�");
		}
		System.out.println("=================");
	   for(int i=0; i<10; i++) {
			int num = (int)(Math.random()*10);
			try {
				System.out.println(num +" : " + msg[num]);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("�迭 ���� �ʰ�");
			}
	   }
	

	}

}
