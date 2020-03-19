package review_ex;
import java.util.Scanner;

class Phone{
	private String name,tel;
	
	public Phone(String name, String tel) {
		this.name=name; this.tel=tel;
	}
	public String getName() {
		return name;
	}
	
	public String getTel() {
		return tel;
	}
}

public class PhoneMain {
	private static Scanner sc=new Scanner(System.in);
	int cnt;
	Phone[] arr;
	
	public PhoneMain() {}
	
	public void inputPhone() {
		System.out.println("입력수>>");
		int num=sc.nextInt();
		arr=new Phone[num];
		for(int i=0; i<num; i++) {
			System.out.print("이름 : ");
			String name=sc.next();
			System.out.print("전화 : ");
			String tel=sc.next();
			arr[i]=new Phone(name, tel);
		}
	}
	
	public void viewPhone() {
		System.out.println("입력된 전화번호부를 출력합니다.");
		for(int i=0; i<arr.length; i++) {
			System.out.println("이름 : "+arr[i].getName()+"\t"+"전화번호 : "+arr[i].getTel()); 
		}
	}
	
	public String searchPhone() {
		System.out.println("찾는 사람의 이름을 입력하세요.");
		String str="";
		String searchName=sc.next();
		boolean flag=false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(searchName)) {
				flag=true;
				str="이름 : "+searchName+"/전화번호 : "+arr[i].getTel()+"\n";
			}
		}
		if(flag=false) str="찾는 친구 없음\n";
		return str;
	}
	
	public static void main(String[] args) {
		PhoneMain pm=new PhoneMain();
		while(true) {
			System.out.println("프로그램을 시작합니다.");
			System.out.println("1.데이터 입력");
			System.out.println("2.데이터 출력");
			System.out.println("3.친구 찾기");
			System.out.println("4.종료");
			System.out.print("선택 : ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1 : 	pm.inputPhone(); break;
			case 2 :	pm.viewPhone(); break;
			case 3 :	System.out.print(pm.searchPhone()); break;
			case 4 : System.out.println("프로그램을 종료합니다.");
							System.exit(0);
			default : System.out.println("입력오류"); 
			}
		}
	}
}