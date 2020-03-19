package chap08_2019_12_03;

//�ʿ� �ִ� ���� ���Ͽ��� �о�鿩�� ��.
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

		hm.clear();// �� Ŭ����
		File dir = new File("src\\Chap08");
		File file = new File(dir, "myCapital.txt"); // dir�� ���� ����
		try {
			if (!file.exists()) {// ������ ������
				file.createNewFile();// ���� �����Ѵ�.
				return; // ������ �ǹ�
			}
			Scanner scanner = new Scanner(file);// ���������� �ѹ��ھ�!!! ��ĳ���̿� //����(myCapital.txt)�� ���� �о����
			while (scanner.hasNext()) {// ������ �е�����.
				String capital = scanner.next();// ���� �б�
				String country = scanner.next();
				hm.put(country, capital);
			}
			scanner.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// ���Ϸ� �о �ʿ� �߰�
	}

	private void input() {

		System.out.println("����" + hm.size() + "�� ����� ���� �Է�"); // map.size :map�� ũ���� ����
		System.out.println("����� x");
		while (true) {
			System.out.println("����� ���� �Է�. ����� x>>");

			String country = CapitalApp.sc.next();// �����б� !!!!!
			if (country.toUpperCase().contentEquals("X"))
				break;
			if (hm.containsKey(country)) {// file�� �Է��� ���� �����ϴ���
				System.out.println("�̹��Է��� �����Դϴ�.");
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

			// ��������
			System.out.println(country + "�� ������? ����� x");
			String answer = CapitalApp.sc.next();
			if (answer.toLowerCase().contentEquals("x"))
				break;
			if (answer.contentEquals(capital)) {
				System.out.println("����");
			} else {
				System.out.println("Ʋ�Ƚ��ϴ�.");
			}
		}

	}// �ؽ����� ���Ͽ� �����ϰ� �����ϴ� �޼ҵ�

	private void save() {
		File dir = new File("src\\chap08");
		File file = new File(dir, "myCapital.txt");
		try {
			FileWriter fw = new FileWriter(file);
			Set<String> set = hm.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();// ����
				String value = hm.get(key);// ����
				fw.write(key + " ");// ����
				fw.write(value + "\n");
			}
			fw.close();
			System.out.println("����");
			System.exit(0);

		} catch (IOException e) {
			System.out.println("�����������");
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
				System.out.println("�Է¿���");
			}
		}

	}

}