package chap05;

public class Child extends Father { 
	//����� �����ܰ� �ö󰡵� �������.(������ �ö󰣴�)
	//�ڹٴ� ���߻���� �������� �ʴ´�.
	public Child() {
		System.out.println("Child ������");
	}
	public void childMethod() {
		System.out.println("childMethod");
	}
	public void fatherMethod() {
		System.out.println("child �������̵� ->fatherMethod");

	}
}
