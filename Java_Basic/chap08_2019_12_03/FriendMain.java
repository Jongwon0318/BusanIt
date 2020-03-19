package chap08_2019_12_03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendMain {
	ArrayList<Friend> arr = new ArrayList<>();// <>안에 Friend형이 들어가야함.
	File dir, file;
	// 파일이 없으면 생성하고
	// 파일이 있으면 ArrayList 추가

	public FriendMain() throws  IOException, ClassNotFoundException {
		dir = new File("src\\chap08_2019_12_03");
		file = new File(dir, "myFriend.txt");
		if (file.exists()) {// 파일 존재
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			arr = (ArrayList<Friend>) ois.readObject();
		} else {// 파일없음
			file.createNewFile();
		}
	}

	private void fileUse() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.친구등록 2.친구보기 3.저장/종료");
			int num = sc.nextInt();
			sc.nextLine(); // enter버리기
			if (num == 1) {// 친구등록
				System.out.println("이름>>");
				String name = sc.nextLine();
				System.out.println("생일>>");
				String birth = sc.nextLine();
				System.out.println("주소>>");
				String addr = sc.nextLine();
				System.out.println("전화>>");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setAddr(addr);
				f.setBirth(birth);
				f.setName(name);
				f.setTel(tel);
				arr.add(f);
			} else if (num == 2) {// 친구보기
				for (Friend fa : arr) {
					System.out.println("이름:" + fa.getName());
					System.out.println("생일:" + fa.getBirth());
					System.out.println("주소:" + fa.getAddr());
					System.out.println("전화번호:" + fa.getTel());
					System.out.println();
				}
			} else if (num == 3) {// 저장/종료 arraylist를 flie로 내보냄. 객체형태의 String으로 내보내야함. objectoutputStreamㅅ사용
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(arr);
				// 종료
				System.out.println("종료");
				System.exit(0);
			} else {// 입력오류
				System.out.println("입력오류");
			}
		}
	}

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {// 호스트하는쪽에서도 예외 처리 throws해줘야함
		FriendMain fm = new FriendMain();
		fm.fileUse();
	}
}
//파일은 스트링으로 내보냄 그러나 파일은 오브잭형태이기 때문에 오브잭형태를 스트링으로 바꿔줘야함. 