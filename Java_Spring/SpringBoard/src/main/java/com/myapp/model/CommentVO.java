package com.myapp.model;

public class CommentVO {
	private int bnum, cnum,cnum_1;
	private String writer, content, regdate, password;

	public String getPassword() {
		return password == "" ? password : password.trim();
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public int getCnum_1() {
		return cnum_1;
	}

	public void setCnum_1(int cnum_1) {
		this.cnum_1 = cnum_1;
	}

	public int getCnum() {
		return cnum;
	}

	public void setCnum(int cnum) {
		this.cnum = cnum;
	}

	public String getWriter() {
		return writer == "" ? writer : writer.trim();
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content == "" ? content : content.trim();
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate == "" ? regdate : regdate.trim();
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
