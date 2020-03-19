package day06_object;

public class TriangleMain {
	public static void main(String[] args) {
		Triangle tr = new Triangle(10.2,17.3);
		System.out.println("삼각형의 면적 : "+tr.getArea());
		tr.setBottom(7.5);
		tr.setHeight(11.2);
		System.out.println("삼각형의 면적 : "+tr.getArea());
	}
}