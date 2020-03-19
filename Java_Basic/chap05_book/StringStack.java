package chap05_book;

 public class  StringStack implements Stack{
	 private String[] arr;
	 private int top; //������ ������ ��ġ //������ ���Ұ� �� ��ġ�� top���� ������ �޶�����.
	 
	 public StringStack(int n) {
		 arr=new String[n];
		 top=-1;
	 }
	 
	@Override
	public int length() { //����� ����
		//���ÿ� ���� �ϳ��� ����Ǿ��ٸ� top=0
		//���ÿ� 2���� ����Ǿ��ٸ� top=1
		return (top+1);
	}

	@Override
	public int capacity() { // �迭�� ũ��
		return arr.length;
	}
	
	@Override
	public boolean push(String val) {
		if(arr.length-1==top) {
			return false;
		}else {
			top++; // �߿�!!!!!!!!!
			arr[top]=val;
			return true;
		}
	}
	
	@Override
	public String pop() {
		if(top==-1) {
			return "�������";
		}else {
			return arr[top--];
		}
	}

}