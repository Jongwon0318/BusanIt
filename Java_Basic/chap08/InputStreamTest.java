package chap08;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest {

	public static void main(String[] args) {
		try {
			FileOutputStream fs 
			= new FileOutputStream("src\\test.txt");
			while(true) {
				int i = System.in.read();
				if(i==-1) break;
				System.out.print((char)i);//ǥ�����(�����)
				fs.write(i);
			}
			fs.close();
		}catch(IOException e) {
			System.out.println("���ܹ߻�");
		}
	
		

	}

}
