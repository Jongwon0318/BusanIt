package chap05;

public class GoodCalc extends Calculator{
	protected int a,b;
	
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	
	@Override
	public int substract(int a, int b) {
		return a-b;
	}
	
	@Override
	public double average(int[] a) {
		int sum=0; 
		/*
		 * for(int i=0; i<a.length; i++) { sum+=a[i]; }
		 */
		for (int i : a) {
			sum+=i;
		}
		return sum/a.length;
	}
	
	public static void main(String[] args) {
		GoodCalc g1=new GoodCalc();
		System.out.println(g1.add(2, 3));
		System.out.println(g1.substract(2, 3));
		System.out.println(g1.average(new int[] {2,3,4}));
	}
}
