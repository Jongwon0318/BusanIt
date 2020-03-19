package day08;

public class ShiftArray {
	
	public static void shiftArray(int[][] arr) {
		int[] tmp= arr[arr.length-1];
		
		for(int i=arr.length-2; i>=0; i--) { //1차원 배열에 있는 값을 저장하는 것....!!
			arr[i+1]=arr[i];
		}
		arr[0]=tmp;
	}
	
	public static void showArray(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	
	
	public static void main(String[] args) {
		int[][] arr= {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("1차 shift......");
		ShiftArray.shiftArray(arr); //이동 메소드
		ShiftArray.showArray(arr); //출력 메소드
		/*ShiftArray sh=new ShiftArray();
		 * sh.shiftArray(arr); --------> ?????
		 */
		System.out.println("2차 shift......");
		ShiftArray.shiftArray(arr); //이동 메소드
		ShiftArray.showArray(arr); //출력 메소드
	}
}