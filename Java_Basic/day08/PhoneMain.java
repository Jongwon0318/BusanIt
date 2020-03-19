package day08;
import java.util.Scanner;

class Phone{ //하나의 파일에 여러개의 클래스가 들어갈 수 있다.
	private String name;
	private String tel;
	
	public Phone(String name, String tel) { //생성자의 이름은 클래스와 같아야한다..!!
		this.name=name; this.tel=tel;
	}
	
	public String getName() { //getter, 보통 private으로 설정하는 변수의 맨 앞자를 대문자로.. 메소드를 만들어서 값을 불러오는 방법을 사용한다.
		return name;
	}
	
	public String getTel() {
		return tel;                 
	}
}

public class PhoneMain {
	int n;
	Phone[] arr; //선언
	Scanner sc=new Scanner(System.in);
	
//입력하기
	public void inputPhone() {
		System.out.println("입력수>>");
		int num=sc.nextInt();
		arr=new Phone[num]; //생성
		for(int i=0; i<num; i++) {
			System.out.print("이름 : ");
			String name=sc.next();
			System.out.print("전화 : ");
			String tel=sc.next();
			arr[i]=new Phone(name, tel); //초기화
		}
	}
	
//이름을 물어보고, 있으면 이름과 전화번호 출력, 없으면 찾는 친구 없습니다.
	public String searchPhone() {
		System.out.println("찾는 사람의 이름을 입력하세요.");
		String str="";
		String searchName=sc.next();
		boolean flag=false;
		for(int i=0; i<arr.length; i++) {
			if(arr[i].getName().equals(searchName)) {
				flag=true;
				str="이름 : "+searchName+"/전화번호 : "+arr[i].getTel();
			}
		}
		if(flag=false) str="찾는 친구 없음";
		return str;
	}
	
//전체보기
	public void viewPhone() {
		for(int i=0; i<arr.length; i++) {
			System.out.println("이름 : "+arr[i].getName()+"\t"+"전화번호 : "+arr[i].getTel()+"\n");
		}
	}

//main절	
	public static void main(String[] args) { //하지만 파일명은 main절을 포함하는 클래스로..!
		PhoneMain pm=new PhoneMain();
		pm.inputPhone();
		pm.viewPhone();
		System.out.println("찾는 친구>>>"+pm.searchPhone());
	}
}