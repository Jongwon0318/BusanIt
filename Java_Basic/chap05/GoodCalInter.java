package chap05;

public class GoodCalInter implements Calc {
	
	public void add(int a,int b) {
		System.out.println("µ¡¼À : "+(a+b));
	}
	
	public void substract(int a,int b) {
		System.out.println("»¬¼À : "+(a-b));
	}
	
	public double average(int[] a) {
		int sum=0;
		for(int i:a) {
			sum+=i;
		}
		return sum/a.length;
	}
	
	public static void main(String[] args) {
		GoodCalInter cc= new GoodCalInter();
		cc.add(2,3);
		cc.substract(2,3);
		System.out.println("Æò±Õ : "+cc.average(new int[] {2,3,4}));;
	}

}
