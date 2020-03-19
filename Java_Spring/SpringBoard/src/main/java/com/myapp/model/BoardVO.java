package com.myapp.model;

public class BoardVO {
	private int num, hitcount;
	private String title,content,writer,regdate,password;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getTitle() {
		return title == "" ? title : title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content == "" ? content : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer == "" ? writer : writer.trim();
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegdate() {
		return regdate == "" ? regdate : regdate.trim();
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPassword() {
		return password == "" ? password : password.trim();
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
