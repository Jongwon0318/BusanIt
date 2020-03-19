package chap08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest01 {

	public static void main(String[] args) {
		 byte b[] = {7, 5 ,3, 2,11};
		 // 배열   b를 읽어 현재패키지의 result.txt 파일로 
		 // 7, 5 ,3, 2,11
		 FileOutputStream fo=null;
		 FileInputStream fi=null;
		 try {
			fo = new FileOutputStream("src\\chap08\\ResultOfFileTest01.txt");
			for(int i=0; i<b.length;i++) {
				fo.write(b[i]);
			}
			
			fi = new FileInputStream("src\\chap08\\result.txt");
			int c;
			while((c=fi.read())!=-1) {
				System.out.print(c +"\t");
			}
			fo.close();
			fi.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}