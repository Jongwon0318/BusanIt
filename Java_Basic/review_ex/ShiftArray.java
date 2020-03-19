package review_ex;

public class ShiftArray {
	public ShiftArray() {}
	
	public static void shiftArray(int[][] arr) {
		int[] tmp=new int[3];
		for(int i=0; i<3; i++) {
			arr[2][i]=tmp[i];
		}
		
		for(int i=arr.length-1; i>0; i--) {
			arr[i]=arr[i-1];
		}
		
		for(int i=0; i<3; i++) {
			tmp[i]=arr[0][i];
		}
	}
	
	public static void showArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("1Â÷ shift...");
		ShiftArray.shiftArray(arr);
		ShiftArray.showArray(arr);
	}
}
