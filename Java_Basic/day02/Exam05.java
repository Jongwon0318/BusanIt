package day02;

//���ǹ� if

public class Exam05 {
	public static void main (String[] args) {
		int a=48;
		System.out.print("a�� ");
		//a�� 50���� ū�� �������� �˰�ʹ�.
		if(a>50) { //true
			System.out.println("50���� ũ��");
		    }else { //false
			System.out.println("50���� �۴�");				
			}
	
		//a�� ¦������ Ȧ������ �Ǵ��ؼ� ���
			//if((a%2)==0 {
			//System.out.println("¦���̴�");
			//}else{
			//System.out.println("Ȧ���̴�");
		System.out.print("a�� ");
			if((a%2)>0) { 
			System.out.println("Ȧ���̴�.");
		}else {
			System.out.println("¦���̴�.");
			}
			/*
			*0�̸�
			*0���� 100���� ��
			*101���� 200 ���� ��
			*201���� 300 ���� ��
			*300�̻�
			*/
			int b=252;
			System.out.print("b�� ");
			if(b<0) { // ���� if
				System.out.println("b�� 0�̸�"); // if(b<=100)�� ���� ǥ���ΰ�?
			}else  if(b<100){									// else�� ������ ������ �湮�Ѵ�.
				System.out.println("0���� 99 ���� ��");
			}else if(b<200) {
				System.out.println("100���� 199 ���� ��");
			}else if(b<300) {
				System.out.println("200���� 299 ���� ��");
			}else {
				System.out.println("300�� �̻��� ��");}
				
			int c=152;
			System.out.print("c�� ");
			if(c<0) {
				System.out.println("0���� ���� ��");
			}if(c>0 && c<100) { //0���� ũ�� 100���� �۴�
				System.out.println("0���� 99 ���� ��");
			}if(c>=100 && c<200) {
				System.out.println("100���� 199 ���� ��");
			}if(c>=200 && c<300) {
				System.out.println("200���� 299 ���� ��");
			}else {
				System.out.println("300�̻� ��");
			}
	}
}