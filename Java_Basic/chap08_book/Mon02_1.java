package chap08_book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Mon02_1 {

	public static void main(String[] args) {
		FileReader fi = null;
		File f=new File("src\\book_chap08\\phone.txt");
		try {
			fi = new FileReader(f);
			int c;
			System.out.println(f.getPath()+"�� ����մϴ�.");
			while ((c=fi.read())!=-1) {
				System.out.print((char)c);
			}
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
