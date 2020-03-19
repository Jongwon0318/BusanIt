package chap07;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		//�迭
				int[] arr=new int[5];
				arr[0]=1; arr[1]=2;
		
		ArrayList alist=new ArrayList();
		alist.add("one");
		alist.add(1); //Integer�� , ������ ���� �ʴ� ����->����Ŭ����..
		alist.add("two");
		alist.add(2);
		System.out.println("alist ũ�� : "+alist.size());
		alist.add("three");
		alist.add(new Integer(3));
		System.out.println("alist ũ�� : "+alist.size());
		System.out.println("two : "+alist.get(2));
		System.out.println("������ : "+alist.get(alist.size()-1));
		for(int i=0; i<alist.size(); i++) {
			System.out.println(alist.get(i));
		}
		//for-each
		for(Object obj : alist){ //Object�� �ֻ��� ��ü�̱⶧���� �̷��� ǥ��. get�� �ҷ����°ͺ��� ����
			System.out.println(obj);
		}
		System.out.println("============");
		//3��° ����
		System.out.println("���� �߰��ϱ�");
		alist.add(2, "����"); // index�� 0 , 1 , 2 ... ����, �� 0���� ������.
		for(Object obj : alist){ //Object�� �ֻ��� ��ü�̱⶧���� �̷��� ǥ��. get�� �ҷ����°ͺ��� ����
			System.out.println(obj);
		}
		
		//0��° ����
		System.out.println("==============");
		alist.remove(0);
		for(Object obj : alist){ //Object�� �ֻ��� ��ü�̱⶧���� �̷��� ǥ��. get�� �ҷ����°ͺ��� ����
			System.out.println(obj);
		}
		System.out.println("���� ���� ��");
		alist.remove("����");
		for(Object obj : alist){ //Object�� �ֻ��� ��ü�̱⶧���� �̷��� ǥ��. get�� �ҷ����°ͺ��� ����
			System.out.println(obj);
		}
		System.out.println("==============");
		//���׸�
		ArrayList<String> blist = new ArrayList<String>(); // ���� <String>�� ������ ��
		//blist.add(1); -> Integer���� �߰��� �� ����.
		blist.add("1");
		blist.add("�ٳ���");
		for(String s:blist) {
			System.out.println(s);
		}
		for(int i=0; i<blist.size(); i++) {
			System.out.println(blist.get(i));
		}
	}
}