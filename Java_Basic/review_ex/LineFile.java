package review_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class LineFile {

	public static void main(String[] args) {
		Scanner sc=null;
		PrintStream ps=null;
		int cnt=0;
		try {
			sc=new Scanner(new File("src\\review_ex\\AppTest.java"));
			ps=new PrintStream(new File("src\\review_ex\\LineFileResult.txt"));
			while(sc.hasNextLine()) {
				ps.println(cnt++ +" : "+sc.nextLine());
			}
		}catch(FileNotFoundException f) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

}
