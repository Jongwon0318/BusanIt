package day07_objectArray;
import java.util.Scanner;

public class BookArray {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Book[] book=new Book[2];
		for(int i=0; i<book.length; i++) {
			System.out.println("å�� ������ �Է��ϼ���.");
			String title=sc.next();
			System.out.println("å�� ���ڸ� �Է��ϼ���.");
			String author=sc.next();
			book[i]=new Book(title, author);
		}
	
		
		
		}
}
