package chap07_book;

public class StudentBean {
	private String name, dept, id;
	private double grade;

	// getter
	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public String getId() {
		return id;
	}

	public double getGrade() {
		return grade;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "StudentBean [name=" + name + ", dept=" + dept + ", id=" + id + ", grade=" + grade + "]";
	}
}
