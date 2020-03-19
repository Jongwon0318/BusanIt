package chap08_2019_12_03;

import java.io.Serializable;

public class Friend implements Serializable {
	private String name;
	private String birth;
	private String addr;
	private String tel;

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getAddr() {
		return addr;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}