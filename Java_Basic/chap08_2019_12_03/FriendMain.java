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
	ArrayList<Friend> arr = new ArrayList<>();// <>�ȿ� Friend���� ������.
	File dir, file;
	// ������ ������ �����ϰ�
	// ������ ������ ArrayList �߰�

	public FriendMain() throws  IOException, ClassNotFoundException {
		dir = new File("src\\chap08_2019_12_03");
		file = new File(dir, "myFriend.txt");
		if (file.exists()) {// ���� ����
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			arr = (ArrayList<Friend>) ois.readObject();
		} else {// ���Ͼ���
			file.createNewFile();
		}
	}

	private void fileUse() throws FileNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.ģ����� 2.ģ������ 3.����/����");
			int num = sc.nextInt();
			sc.nextLine(); // enter������
			if (num == 1) {// ģ�����
				System.out.println("�̸�>>");
				String name = sc.nextLine();
				System.out.println("����>>");
				String birth = sc.nextLine();
				System.out.println("�ּ�>>");
				String addr = sc.nextLine();
				System.out.println("��ȭ>>");
				String tel = sc.nextLine();
				Friend f = new Friend();
				f.setAddr(addr);
				f.setBirth(birth);
				f.setName(name);
				f.setTel(tel);
				arr.add(f);
			} else if (num == 2) {// ģ������
				for (Friend fa : arr) {
					System.out.println("�̸�:" + fa.getName());
					System.out.println("����:" + fa.getBirth());
					System.out.println("�ּ�:" + fa.getAddr());
					System.out.println("��ȭ��ȣ:" + fa.getTel());
					System.out.println();
				}
			} else if (num == 3) {// ����/���� arraylist�� flie�� ������. ��ü������ String���� ����������. objectoutputStream�����
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(arr);
				// ����
				System.out.println("����");
				System.exit(0);
			} else {// �Է¿���
				System.out.println("�Է¿���");
			}
		}
	}

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {// ȣ��Ʈ�ϴ��ʿ����� ���� ó�� throws�������
		FriendMain fm = new FriendMain();
		fm.fileUse();
	}
}
//������ ��Ʈ������ ������ �׷��� ������ �����������̱� ������ ���������¸� ��Ʈ������ �ٲ������. 