package day06_object;

public class ArrayTest {
	public ArrayTest() {}
	
	public void sum(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println("�迭�� �հ� : "+sum);
	}
	public static void main(String[] args) {
		int[] d= {10,5,36,45,9};
		ArrayTest at=new ArrayTest();
		at.sum(d); //�迭�� �հ� ���
	}
}