package com.exam;

public class ScoreBean {
	String name,grade;
	int kor,eng,math,total,avg;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public String getGrade() {
		if(avg>=90){
			this.grade="A";
		}else	if(avg>=80){
			this.grade="B";
		}else	if(avg>=70){
			this.grade="C";
		}else{
			this.grade="F";
		}
		return grade;
	}
	public int getTotal() {
		this.total = kor+eng+math;
		return total;
	}
	public int getAvg() {
		this.avg = total/3;
		return avg;
	}
}
