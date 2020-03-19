package chap05_book;

 public class  StringStack implements Stack{
	 private String[] arr;
	 private int top; //마지막 원소의 위치 //마지막 원소가 들어갈 위치를 top으로 놓으면 달라진다.
	 
	 public StringStack(int n) {
		 arr=new String[n];
		 top=-1;
	 }
	 
	@Override
	public int length() { //저장된 개수
		//스택에 원소 하나가 저장되었다면 top=0
		//스택에 2개가 저장되었다면 top=1
		return (top+1);
	}

	@Override
	public int capacity() { // 배열의 크기
		return arr.length;
	}
	
	@Override
	public boolean push(String val) {
		if(arr.length-1==top) {
			return false;
		}else {
			top++; // 중요!!!!!!!!!
			arr[top]=val;
			return true;
		}
	}
	
	@Override
	public String pop() {
		if(top==-1) {
			return "비어있음";
		}else {
			return arr[top--];
		}
	}

}