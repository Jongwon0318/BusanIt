package chap08;

import java.io.FileOutputStream;
import java.io.IOException;

public class InputStreamTest_my {

	public static void main(String[] args) {
		try {
			FileOutputStream fs= new FileOutputStream("test.txt");
			while (true) {
				int i = System.in.read();
				if(i==-1) break;
				System.out.print((char)i); //표준출력(모니터)
				fs.write(i); //파일로 내보내는 것
			}
			fs.close();
		} catch (IOException e) {
			System.out.println("예외 발생");
		}
	}

}
