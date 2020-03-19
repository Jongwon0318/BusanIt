package chap09.player;

public class Player {
	private int num;
	private String name, birth, kind;
	private Double height, weight;

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getBirth() {
		return birth;
	}

	public String getKind() {
		return kind;
	}

	public Double getHeight() {
		return height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

}
