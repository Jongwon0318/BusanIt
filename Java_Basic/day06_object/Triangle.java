package day06_object;

public class Triangle {
	double b;
	double h;
	public Triangle(double b, double h) {
		this.b=b; this.h=h;
	}
	public double getArea() {
		 return(b*h*0.5);
	}
	public void setBottom(double b) {
		this.b=b;
	}
	public void setHeight(double h) {
		this.h=h;
	}
}