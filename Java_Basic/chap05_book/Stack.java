package chap05_book;

public interface Stack {
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}