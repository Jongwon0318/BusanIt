package chap07;

import java.util.HashMap;
import java.util.Scanner;

public class HastMaptest05Answer {

	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap();
		hm.put("java","1111");
		hm.put("oracle","1234");
		hm.put("jsp","abcd");
		Scanner sc=new Scanner(System.in);
		System.out.println("id/password를 입력하세요");
		System.out.print("id : ");
		String id=sc.next();
		if(!hm.containsKey(id)) {
			System.out.println("입력하신 id가 없습니다");
		}
		System.out.print("password : ");
		String pwd=sc.next();
		//입력한 id의 비밀번호를 구하고, 그 비밀번호와 같은지 물어보기
		if(hm.get(id).equals(pwd)){
			System.out.println("모두 일치");
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
	}

}
