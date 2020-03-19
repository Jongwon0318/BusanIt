package day09;

public class Player {
	private String name,address;
	private int age;
	private double height;
	private double weight;
	
	public Player(String name, String address, int age, double height, double weight) {
		this.name=name; 
		this.address=address; 
		this.age=age; 
		this.height=height; 
		this.weight=weight;
	} //Player�� ������
	
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
}