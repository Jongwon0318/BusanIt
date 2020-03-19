package chap08_2019_12_03;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class CapitalApp {
	 static Scanner sc=new Scanner(System.in);

	private HashMap<String,String>map
	=new HashMap<String,String>();

	public CapitalApp() {
		map.put("한국","서울");
		map.put("일본", "도쿄");
		map.put("프랑스", "파리");
		map.put("중국", "베이징");
		map.put("영국", "런던");
		map.put("미국", "워싱턴");
	}
	public static void showMenu() { //static 쓰는 이유 메인에 스태이틱이 있기때문에
		System.out.println("***수도 맞추기 게임을 시작합니다.**");
		System.out.println("입력:1, 퀴즈:2, 종료:3>>");

	}
	private void input() { // static 안쓰는이유....
		System.out.println("현재"+map.size()+"개 나라와 수도 입력"); //map.size :map의 크기의 갯수
		System.out.println("종료는 x");
		while(true) {
			System.out.println("나라와 수도 입력. 종료는 x>>");

			String cont=sc.next();//나라
			if(cont.toUpperCase().contentEquals("X")) break;
			if(map.containsKey(cont)) {//map에 입력한 나라가 존재하는지 
				System.out.println("이미 입력한 나라입니다.");
				continue; //while문이 돌아가게 ? 
			}
			String sudo=sc.next(); //수도
			map.put(cont,sudo);}
	}private void test() {//컴퓨터가 랜덤하게 도시를 알려주면 그에 대한 수도를 입력하면 답 판단해줌!
		Set<String> set=map.keySet();//나라만 가져옴
		Object[] arr= set.toArray();//set을 배열 형태로 변환(순서를 알기위해)
		while(true) {
			int n=(int)(Math.random()*map.size()); //난수발생
			String city =(String) arr[n];//나라 이름  String하는이유: arr는 obj객체(최상위객채)니까String 으로 변환해줘야함.
			String dosi=map.get(city);

			//문제출체
			System.out.println(city+"의 수도는?종료는 x");
			String dap= sc.next();
			if(dap.toLowerCase().contentEquals("x")) break;
			if(dap.contentEquals(dosi)) {
				System.out.println("정답");}
			else {
				System.out.println("틀렸습니다.");
			}
		}
	}

	public static void main(String[] args) {
		CapitalApp ca = new CapitalApp();
		while(true) {
			CapitalApp.showMenu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:ca.input(); break;
			case 2:ca.test(); break;
			case 3: System.out.println("종료");
			System.exit(0);
			default:System.out.println("입력오류");
			}
		}
	}
}