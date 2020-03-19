package day07_objectArray;
import java.util.Scanner;

public class BookArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Book[] book=new Book[2];
		for(int i=0; i<book.length; i++) {
			System.out.println("책의 제목을 입력하세요.");
			String title=sc.next();
			System.out.println("책의 저자를 입력하세요.");
			String author=sc.next();
			book[i]=new Book(title, author);
		}
	
		
		
		}
}
