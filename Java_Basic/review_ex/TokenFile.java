package review_ex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class TokenFile {

	public static void main(String[] args) {
		Scanner sc=null;
		PrintStream ps=null;
		try {
			sc=new Scanner(new File("src\\chap08\\aa.txt"));
			ps=new PrintStream(new File("src\\review_ex\\TokenFileResult.txt"));
			
			while(sc.hasNextLine()) {
				String[] arr=sc.nextLine().split(":");
				for(int i=0; i<arr.length; i++) {
					ps.print(Integer.toHexString(Integer.parseInt(arr[i]))+"\t");
				}
			}
		}catch(FileNotFoundException f) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}

}
