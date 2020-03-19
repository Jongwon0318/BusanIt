package chap08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class LineFile02 {

	public static void main(String[] args) {
		Scanner sc=null;
		PrintStream ps=null; //필터스트림
		try {
			sc=new Scanner(new File("src\\chap08\\LineFileanswer.java"));
			ps=new PrintStream(new File("src\\chap08\\output11.txt"));
			int cnt=1;
			while(sc.hasNext()) {
				ps.println(cnt+" : "+sc.nextLine());
				cnt++;
			}
		}catch(FileNotFoundException f){
			System.out.println("파일 없어요");
		}finally {
			sc.close();
			ps.close();
		}
	}
}