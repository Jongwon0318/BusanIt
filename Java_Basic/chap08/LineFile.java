package chap08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineFile {

	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		int c;
		int cnt = 1;
		try {
			fr = new FileReader("src\\chap08\\InputReaderTest.java");
			while (true) {
				if ((c = fr.read()) == -1)
					break;
			}
			fr.close();
			fw = new FileWriter("src\\chap08\\input.txt");
			while (true) {
				fw.write((cnt++) + " : ");
				fw.write(c);
				if ((c == -1))
					break;
			}
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
