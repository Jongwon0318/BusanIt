package review_ex;

public class Circle {
	double r;
	
	private Circle(double r) {
		this.r=r;
	}
	
	public double getArea() {
		return 3.14*r*r;
	}

	public static void main(String[] args) {
		Circle[] arr=new Circle[5];
		for(int i=0; i<arr.length; i++) {
			arr[i]=new Circle(i+1);
		}
		double sum=0;
		for(int i=0; i<arr.length; i++) {
			System.out.println("¹ÝÁö¸§ : "+(i+1)+"\t"+"¿øÀÇ ³ÐÀÌ : "+arr[i].getArea());
			sum+=arr[i].getArea();
		}
		System.out.println("³ÐÀÌÀÇ ÃÑÇÕ : "+sum);
	}
}