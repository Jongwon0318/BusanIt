package chap08_2019_12_03;

//맵에 있는 것을 파일에서 읽어들여서 씀.
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.io.FileWriter;

public class CapitalApp2 {
	private HashMap<String, String> hm = new HashMap<String, String>();

	public CapitalApp2() {

		hm.clear();// 맵 클리어
		File dir = new File("src\\Chap08");
		File file = new File(dir, "myCapital.txt"); // dir을 쓰는 이유
		try {
			if (!file.exists()) {// 파일이 없으면
				file.createNewFile();// 파일 생성한다.
				return; // 종료의 의미
			}
			Scanner scanner = new Scanner(file);// 파일읽을때 한문자씩!!! 스캐너이용 //파일(myCapital.txt)로 부터 읽어들임
			while (scanner.hasNext()) {// 끝까지 읽도록함.
				String capital = scanner.next();// 수도 읽기
				String country = scanner.next();
				hm.put(country, capital);
			}
			scanner.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// 파일로 읽어서 맵에 추가
	}

	private void input() {

		System.out.println("현재" + hm.size() + "개 나라와 수도 입력"); // map.size :map의 크기의 갯수
		System.out.println("종료는 x");
		while (true) {
			System.out.println("나라와 수도 입력. 종료는 x>>");

			String country = CapitalApp.sc.next();// 나라읽기 !!!!!
			if (country.toUpperCase().contentEquals("X"))
				break;
			if (hm.containsKey(country)) {// file에 입력한 나라가 존재하는지
				System.out.println("이미입력한 나라입니다.");
				continue;
			}
			String capital = CapitalApp.sc.next();
			hm.put(country, capital);
		}

	}

	private void quiz() {
		Set<String> set = hm.keySet();
		Object[] arr = set.toArray();
		while (true) {
			int n = (int) (Math.random() * hm.size());
			String country = (String) arr[n];
			String capital = hm.get(country);

			// 문제출제
			System.out.println(country + "의 수도는? 종료는 x");
			String answer = CapitalApp.sc.next();
			if (answer.toLowerCase().contentEquals("x"))
				break;
			if (answer.contentEquals(capital)) {
				System.out.println("정답");
			} else {
				System.out.println("틀렸습니다.");
			}
		}

	}// 해쉬맵을 파일에 저장하고 종료하는 메소드

	private void save() {
		File dir = new File("src\\chap08");
		File file = new File(dir, "myCapital.txt");
		try {
			FileWriter fw = new FileWriter(file);
			Set<String> set = hm.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();// 나라
				String value = hm.get(key);// 수도
				fw.write(key + " ");// 나라
				fw.write(value + "\n");
			}
			fw.close();
			System.out.println("종료");
			System.exit(0);

		} catch (IOException e) {
			System.out.println("파일저장오류");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		CapitalApp2 ca2 = new CapitalApp2();
		while (true) {
			CapitalApp.showMenu();
			int choice = CapitalApp.sc.nextInt();

			switch (choice) {
			case 1:
				ca2.input();
				break;
			case 2:
				ca2.quiz();
				break;
			case 3:
				ca2.save();
				break;

			default:
				System.out.println("입력오류");
			}
		}

	}

}