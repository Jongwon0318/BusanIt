package com.person.model;

public class PersonVO {
	private String id, password, name, gender, job;

	public String getId() {
		return id == "" ? id : id.trim();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password == "" ? password : password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name == "" ? name : name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender == "" ? gender : gender.trim();
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job == "" ? job : job.trim();
	}

	public void setJob(String job) {
		this.job = job;
	}	
	
}
