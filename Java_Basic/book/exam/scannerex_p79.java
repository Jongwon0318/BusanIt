package book.exam;
import java.util.Scanner;
//이름,도시,나이,체중,독신여부
public class scannerex_p79 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력하세요.");
		String name=sc.next();
		
		System.out.println("거주도시를 입력하세요.");
		String city=sc.next();
		
		System.out.println("나이를 입력하세요.");
		int age=sc.nextInt();
		
		System.out.println("체중을 입력하세요.");
		double weight=sc.nextDouble();
		
		System.out.println("독신여부를 O 또는 X로 입력하세요.");
		String marrige=sc.next();
		
		System.out.println("이름 : "+name+"\n"+"거주도시 : "+city+"\n"
											+"나이 : "+age+"세"+"\n"+"체중 : "+weight+"kg"+"\n"
											+"독신여부 : "+marrige+"\n");
	}
}
