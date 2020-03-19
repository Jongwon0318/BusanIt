package review_ex;

public class ArrayTest {
	public ArrayTest() {}
	
	int[] d= {10,5,36,45,9};
	int sum=0;
	
	public void sum(int[] d) {
		for(int i=0; i<d.length; i++) {
			sum+=d[i];
		}
		System.out.println("배열의 합 : "+sum);
	}
	
	public static void main(String[] args) {
		int[] d= {10,5,36,45,9};
		ArrayTest at=new ArrayTest();
		at.sum(d);
	}
}