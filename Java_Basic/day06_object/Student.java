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
		Student s1 = new Student("ȫ�浿",100,80);
		Student s2 = new Student("�̼���",50,70);
		System.out.println("�̸�\t\t����\t\t����\t\t����\t\t���");
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