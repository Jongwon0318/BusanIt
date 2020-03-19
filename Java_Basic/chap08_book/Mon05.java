package chap08_book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Mon05 {

	public static void main(String[] args) {
		Scanner sc = null;
//		Scanner sc2 = null;
		FileInputStream f1 = null;
		FileInputStream f2 = null;

		System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
		sc = new Scanner(System.in);
		System.out.print("첫번째 파일 이름을 입력하세요.>>");
		String firstfile = sc.next();
		System.out.print("두번째 파일 이름을 입력하세요.>>");
		String secondfile = sc.next();
		sc.close();
		System.out.println(firstfile + "와 " + secondfile + "를 비교합니다.");
		try {
//			sc = new Scanner(new File("src\\book_chap08\\" + firstfile));
//			sc2 = new Scanner(new File("src\\book_chap08\\" + secondfile));

			f1 = new FileInputStream(new File("src\\book_chap08\\" + firstfile));
			f2 = new FileInputStream(new File("src\\book_chap08\\" + secondfile));

//			StringBuffer sb=new StringBuffer(1024);
//			while (sc.hasNextLine()) {
//				String scstr = sc.nextLine();
//				String scstr2 = sc2.nextLine();
//				if (scstr.equals(scstr2)) {
//					System.out.print("두 파일은 같습니다.");
//				} else {
//					System.out.print("두 파일은 다릅니다.");
//					break;
//				}
//			}
//			int c;
//			f1.equals(f2);
//			while((c=f1.read())!=-1) {
//				if(c==f2.read()) {
//					System.out.print("두 파일은 같습니다.");
//				}else {
//					System.out.print("두 파일은 다릅니다.");
//				}
//			}

			if (f1.equals(f2)) {
				System.out.print("두 파일은 같습니다.");
			} else {
				System.out.print("두 파일은 다릅니다.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
		} 

	}
}