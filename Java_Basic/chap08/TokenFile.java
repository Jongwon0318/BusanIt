package chap08;

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
			ps=new PrintStream(new File("src\\chap08\\bb.txt"));
			while(sc.hasNext()) {
				String[] arr=sc.nextLine().split(":");
				for(int i=0; i<arr.length; i++) {
					ps.print(Integer.toHexString(Integer.parseInt(arr[i])).toUpperCase()+"\t");
				}
			}
		}catch(FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		}finally {
			sc.close();
			ps.close();
		}
	}

}
