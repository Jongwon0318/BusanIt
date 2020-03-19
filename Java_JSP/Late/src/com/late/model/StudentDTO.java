package com.late.model;

public class StudentDTO {
	String name;
	int lateCount;
	
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLateCount() {
		return lateCount;
	}
	public void setLateCount(int lateCount) {
		this.lateCount = lateCount;
	}
	
}
