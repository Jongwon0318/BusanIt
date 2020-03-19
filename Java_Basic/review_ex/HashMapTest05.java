
package review_ex;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapTest05 {

	public static void main(String[] args) {
		HashMap<String, String> hm=new HashMap();
		hm.put("java","1111");
		hm.put("oracle","1234");
		hm.put("jsp","abcd");
		Scanner sc=new Scanner(System.in);
		//입력하신 id가 없습니다 , 비밀번호가 일치하지 않습니다, 모두 일치
		System.out.println("id/password를 입력하세요.");
		System.out.print("id : ");
		String id=sc.next();
		if(hm.containsKey(id)==false) {
			System.out.println("입력하신 id가 없습니다.");
		}else {
			System.out.print("password : ");
			String pwd=sc.next();
			if(hm.containsValue(pwd)) {
				System.out.println("모두 일치");
			}else {
				System.out.println("password 오류");
			}
		}
		sc.close();
		
	}

}
