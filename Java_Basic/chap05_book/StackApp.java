package chap05_book;
import java.util.Scanner;

public class StackApp{

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("총 스택 저장 공간의 크기 입력 >>");
		int n=sc.nextInt();
		StringStack ss=new StringStack(n);
		
		while(true) {
			System.out.print("문자열 입력 >> ");
			String str=sc.next();
			if(str.equals("exit")) break;
			boolean flag = ss.push(str);
			if(flag==false) {
				System.out.println("스택이 꽉 차서 푸시 불가");
			}
		}
		System.out.println("스택에 저장된 모든 문자열 팝 : ");
		for(int i=0; i<ss.length(); i++) {
			System.out.println(ss.pop()+"\t");
		}
		
		sc.close();
	}

}
