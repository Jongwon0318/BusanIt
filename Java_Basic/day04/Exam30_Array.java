package day04;

//�迭 : ���� �ڷ����� ��Ƶδ� ��, ũ�⸦ �����ؾ��Ѵ�.
public class Exam30_Array {
	public static void main(String[ ] agrs) {
		int[] arr=new int[5]; //�߿��ϴ�! 0 1 2 3 4 �� �ټ��� ��, 
		System.out.println(arr);
		System.out.println(arr[0]); //int�� �ʱⰪ�� 0�̴�.
		arr[0]=100;
		System.out.println(arr[0]);
		//arr[0]="Java"; �Ұ���
		arr[1]=200;
		arr[2]=300;
		arr[3]=400;
		arr[4]=500;
		//arr[5]=600;
		for(int i=0; i<arr.length; i++) { //length �߿�!! 
			System.out.println(arr[i]);
		}
		int[] arr2 = {1,2,3,4,5,6,7}; //????????
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		/*
		 * int[] arr2 = new int[7];
		 * arr2[0]=1;
		 * arr2[1]=2;
		 * arr2[2]=3;
		 * arr2[3]=4;
		 * arr2[4]=5;
		 * arr2[5]=6;
		 * arr2[6]=7;
		 * */
		 String[] str= {"one","two","three","four"};
		 for(int i=0; i<str.length; i++) {
			 System.out.println(str[i]);
		 }
	}
}

/*	about �ڹ��� �ڷ���...
*�ڹ��� ����(���۷���)��(�ּҰ�) : �迭 Ŭ���� �������̽�
* : �ڹ��� �⺻ ��������(��������) 8���� : char byte int long  float double boolean short 
*/