package com.examAction;

public class Person {
	private String name, userid, pwd, gender, job;
	private String[] notice;

	public String getName() {
		return name == null ? "" : name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid == null ? "" : userid.trim();
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPwd() {
		return pwd == null ? "" : pwd.trim();
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender == null ? "" : gender.trim();
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJob() {
		return job == null ? "" : job.trim();
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String[] getNotice() {
		return notice;
	}

	public void setNotice(String[] notice) {
		this.notice = notice;
	}

}
