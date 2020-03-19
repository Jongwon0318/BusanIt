package chap09;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bank extends JFrame {

	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	List lst;
	public Bank() {
		super("Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));

		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));

		JPanel p1 = new JPanel(); // ���� ù����
		p1.add(new JLabel("�̸�"));
		JTextField tfName = new JTextField(15);
		p1.add(tfName);

		JButton btn = new JButton("���»���");

		JPanel p2 = new JPanel();
		p2.add(new JLabel("�ܾ�"));
		JTextField tfBalance = new JTextField(15);
		tfBalance.setEnabled(false);
		p2.add(tfBalance);

		JPanel p3 = new JPanel();
		JTextField tfMoney = new JTextField(15);
		p3.add(tfMoney);
		p3.add(new JLabel("��"));

		JPanel p4 = new JPanel();
		JButton inputBtn = new JButton("����");
		JButton outputBtn = new JButton("���");
		JButton fileBtn = new JButton("���Ϸ� ����");
		p4.add(inputBtn);
		p4.add(outputBtn);
		p4.add(fileBtn);

		left.add(p1);
		left.add(btn);
		left.add(p2);
		left.add(p3);
		left.add(p4);

		lst=new List();
		
		add(left);
		add(lst);

		setSize(500, 300);
		setVisible(true);

		load();

		btn.addActionListener(new ActionListener() {
			// �Է��� �̸��� ����Ʈ�� �߰�, �ؽ��ʿ� �߰�
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tfName.getText().isEmpty())
					return;
				lst.add(tfName.getText().trim());
				hm.put(tfName.getText().trim(), 0);
				tfName.setText("");
			}
		});

		lst.addItemListener(new ItemListener() {
			// ����Ʈ���� �ش� �̸��� �����ϸ� �ܾ��� ��µǵ���
			@Override
			public void itemStateChanged(ItemEvent e) {
				String name = lst.getSelectedItem().trim();
				tfName.setText(name);
				tfBalance.setText(String.valueOf(hm.get(name)));
			}
		});

		inputBtn.addActionListener(new ActionListener() {
			// ����Ʈ�� ���õ� ���� �ܾ׿� �󸶸� ���ؼ� �ܾ� �����ְ� �ʿ� �߰�
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem().trim();
					hm.replace(name, hm.get(name) + Integer.parseInt(tfMoney.getText()));
					tfBalance.setText(String.valueOf(hm.get(name)));
					tfMoney.setText("");
				} catch (NullPointerException n) {
					new MessageBox("SelectionError", "���¸� �������ּ���...");
				} catch (NumberFormatException ne) {
					new MessageBox("InputError", "���ڸ� �Է����ּ���...");
				}
			}
		});

		outputBtn.addActionListener(new ActionListener() {
			// ����Ʈ�� ���õ� ���� �ܾ׿� �󸶸� ���� �ܾ� �����ְ� �ʿ� �߰�
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem().trim();
					if (hm.get(name) - Integer.parseInt(tfMoney.getText()) < 0) {
						new MessageBox("LowBalance", name + "�� �ܾ��� �����մϴ�.");
						return;
					}
					hm.replace(name, hm.get(name) - Integer.parseInt(tfMoney.getText()));
					tfBalance.setText(String.valueOf(hm.get(name)));
					tfMoney.setText("");
				} catch (NullPointerException n) {
					new MessageBox("SelectionError", "���¸� �������ּ���...");
				} catch (NumberFormatException ne) {
					new MessageBox("InputError", "���ڸ� �Է����ּ���...");
				}
			}
		});

		fileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File dir = new File("src\\chap09");
				File file = new File(dir, "mybank.txt");

				try {
					FileWriter fw = new FileWriter(file);
					Set<String> set = hm.keySet();
					Iterator<String> it = set.iterator();
					while (it.hasNext()) {
						String key = it.next();
						fw.write(key + " ");
						fw.write(hm.get(key) + "\n");
					}
					fw.close();
				} catch (IOException e1) {
					new MessageBox("���Ͽ���!!!", "���� ���� ���� �߻�");
					e1.printStackTrace();
				}
			}
		});

	}

	private void load() {
		// file->hm �ֱ�
		hm.clear();
		File dir = new File("src\\chap09");
		File file = new File(dir, "mybank.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				return;
			}else {
				Scanner sc=new Scanner(file);
				while(sc.hasNext()) {
					String name=sc.next();
					int money=sc.nextInt();
					hm.put(name, money);
					lst.add(name+"\n");
				}
			}
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Bank();
	}
}