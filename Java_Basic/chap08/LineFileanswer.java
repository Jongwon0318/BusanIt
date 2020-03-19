package chap08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineFileanswer {

	public static void main(String[] args) {
		try {
			FileReader fi=new FileReader("src\\chap08\\InputStreamTest.java");
			FileWriter fw=new FileWriter("src\\input11.txt");
			int cnt=1;
			fw.write(cnt+" : ");
			int c;
			while((c=fi.read())!=-1) {
				if(c==10) continue;
				if(c==13) {
					cnt++;
					fw.write((char)c);
					fw.write(cnt+" : ");
				}else {
					fw.write((char)c);
				}
			}
			fi.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
