package review_ex2;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
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

//1.Bank
//
//�̸�						��
//���»���(��ư)		��
//�ܾ�						Ʈ
//��							��
//�Ա� ���(��ư)    	��

// �Է��� �̸��� ����Ʈ�� �߰�, �ؽ��ʿ� �߰�
// ����Ʈ���� �ش� �̸��� �����ϸ� �ܾ��� ��µǵ���
// ����Ʈ�� ���õ� ���� �ܾ׿� �󸶸� ���ؼ� �ܾ� �����ְ� �ʿ� �߰�
// ����Ʈ�� ���õ� ���� �ܾ׿� �󸶸� ���� �ܾ� �����ְ� �ʿ� �߰�
	JTextField tfName, tfBalance, tfMoney;
	JButton btn1, btn2, btn3, fileBtn;
	List lst;
	HashMap<String, Integer> hm = new HashMap<>();

	public Bank() {
		super("Bankapp");
		setLayout(new GridLayout(1, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tfName = new JTextField(15);
		tfBalance = new JTextField(15);
		tfBalance.setEnabled(false);
		tfMoney = new JTextField(15);
		btn1 = new JButton("���»���");
		btn2 = new JButton("�Ա�");
		btn3 = new JButton("���");
		fileBtn=new JButton("���Ϸ� ����");
		lst = new List();
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(5, 1));
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();
		JLabel Jname = new JLabel("�̸�");
		JLabel leftover = new JLabel("�ܾ�");
		JLabel won = new JLabel("��");
		p1.add(Jname);
		p1.add(tfName);
		p2.add(btn1);
		p3.add(leftover);
		p3.add(tfBalance);
		p4.add(tfMoney);
		p4.add(won);
		p5.add(btn2);
		p5.add(btn3);
		p5.add(fileBtn);
		left.add(p1);
		left.add(p2);
		left.add(p3);
		left.add(p4);
		left.add(p5);
		add(left);
		add(lst);
		load();
		setSize(600, 300);
		setVisible(true);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lst.add(tfName.getText().trim());
				hm.put(tfName.getText(), 0);
				tfName.setText("");
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem();
					hm.replace(name, hm.get(name) + Integer.parseInt(tfMoney.getText()));
					tfBalance.setText(hm.get(name) + "");
					tfMoney.setText("");
				} catch(NullPointerException n1) {
					new MessageBox("���ÿ���!!","���¸� �����ϼ���");
				}catch (NumberFormatException n2) {
					new MessageBox("�Է¿���!!","���ڸ� �Է��ϼ���");
				}
			}
		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = lst.getSelectedItem();
					hm.replace(name, hm.get(name) - Integer.parseInt(tfMoney.getText()));
					tfBalance.setText(hm.get(name) + "");
					tfMoney.setText("");
				} catch(NullPointerException n1) {
					new MessageBox("���ÿ���!!","���¸� �����ϼ���");
				}catch (NumberFormatException n2) {
					new MessageBox("�Է¿���!!","���ڸ� �Է��ϼ���");
				}
			}
		});

		lst.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				String name = lst.getSelectedItem().trim();
				tfName.setText(name);
				tfBalance.setText(hm.get(name) + "");
			}
		});
		
		fileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				File dir=new File("src\\review_ex2");
				File f=new File(dir,"data.txt");
				try {
					FileWriter fw=new FileWriter(f);
					Set<String> keys=hm.keySet();
					Iterator<String> it=keys.iterator();
					while(it.hasNext()) {
						String str=it.next();
						fw.write(str+"\t"+hm.get(str)+"\n");
					}
					fw.close();
				} catch (IOException e1) {
					new MessageBox("����¿���","����� ���� �߻�");
				}
			}
		});
		
	}
	public void load() {
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
