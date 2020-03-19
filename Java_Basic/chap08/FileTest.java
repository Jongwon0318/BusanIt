package chap08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		try {
			FileInputStream fi 
			= new FileInputStream("src\\chap08\\result.txt");
		    FileOutputStream fo
		    =new FileOutputStream("output.txt");
		    int c;
		    while((c=fi.read())!=-1){
		    	System.out.print((char)c);
		    	fo.write(c);
		    }
		    fi.close();
		    fo.close();
		}catch(FileNotFoundException n) {
			System.out.println("파일이 없어요");
		}catch(IOException e){
			System.out.println("파일 입출력 오류");
		}
		

	}

}
