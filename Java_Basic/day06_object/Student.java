package day06_object;

public class Student {
	String name;
	int kor;
	int mat;
	public Student(String name, int kor, int mat) {
		this.name=name; this.kor=kor; this.mat=mat;
	}
	
	public int getTotal() {
		return kor+mat;
	}
	
	public double getAvg() {
		return (kor+mat)/2;
	}
	public static void main(String[] args) {
		Student s1 = new Student("홍길동",100,80);
		Student s2 = new Student("이순신",50,70);
		System.out.println("이름\t\t국어\t\t수학\t\t총점\t\t평균");
		System.out.print(s1.name+"\t");
		System.out.print(s1.kor+"\t\t ");
		System.out.print(s1.mat+"\t\t");
		System.out.print(s1.getTotal()+"\t\t");
		System.out.println(s1.getAvg()+"\t ");
		
		System.out.print(s2.name+"\t");
		System.out.print(s2.kor+"\t\t ");
		System.out.print(s2.mat+"\t\t");
		System.out.print(s2.getTotal()+"\t\t");
		System.out.println(s2.getAvg()+"\t ");
	}
}