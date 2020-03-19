package chap09.player;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayerView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	PlayerDBA dba = new PlayerDBA();
	JTextField[] tf = new JTextField[6];
	JTextArea ta;
	String name, birth, kind;
	Double weight, height;
	Player p;

	public PlayerView() {
		setTitle("Player");
		Container c = getContentPane();
		c.setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.add(new PlayerPanel()); // 1�� 1��

		ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					int num = Integer.parseInt(ta.getSelectedText().trim());
					p = dba.playerDetail(num);
					tf[0].setText(num + "");
					tf[1].setText(p.getName());
					tf[2].setText(p.getBirth());
					tf[3].setText(p.getHeight() + "");
					tf[4].setText(p.getWeight() + "");
					tf[5].setText(p.getKind());
				} catch (NullPointerException n2) {
					JOptionPane.showMessageDialog(null, "���ڸ� �巡���Ͽ� �����ϼ���.");
				} catch (NumberFormatException n1) {
					JOptionPane.showMessageDialog(null, "���ڸ� �巡���Ͽ� �����ϼ���.");
				}
			}
		});

		c.add(jsp); // 1�� 2��

		JPanel p1 = new JPanel();
		JButton insertBtn = new JButton("�߰�");
		JButton viewBtn = new JButton("����");
		JButton updateBtn = new JButton("����");
		JButton deleteBtn = new JButton("����");
		p1.add(insertBtn);
		p1.add(viewBtn);
		p1.add(updateBtn);
		p1.add(deleteBtn);
		c.add(p1); // 2�� 1��

		JPanel p2 = new JPanel();
		JComboBox<String> cb = new JComboBox<String>();
		cb.addItem("�̸�");
		cb.addItem("����");
		JTextField searchTf = new JTextField(10);
		JButton searchBtn = new JButton("�˻�");
		p2.add(cb);
		p2.add(searchTf);
		p2.add(searchBtn);
		c.add(p2); // 2�� 2��

		setSize(600, 400);
		setVisible(true);

		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				name = tf[1].getText();
				birth = tf[2].getText();
				height = Double.parseDouble(tf[3].getText());
				weight = Double.parseDouble(tf[4].getText());
				kind = tf[5].getText();
				p = new Player();
				p.setName(name);
				p.setBirth(birth);
				p.setHeight(height);
				p.setWeight(weight);
				p.setKind(kind);
				dba.playerInsert(p);
				viewBtn.doClick();
				for(int i=0; i<tf.length; i++) {
					tf[i].setText("");
				}
			}
		});

		viewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				ArrayList<Player> arr = dba.playerView();
				for (Player p1 : arr) {
					ta.append("��ȣ : " + p1.getNum() + "\n");
					ta.append("�̸� : " + p1.getName() + "\n");
					ta.append("���� : " + p1.getBirth() + "\n");
					ta.append("Ű : " + p1.getHeight() + "\n");
					ta.append("������ : " + p1.getWeight() + "\n");
					ta.append("���� : " + p1.getKind() + "\n");
					ta.append("\n");
				}
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Player();
				p.setNum(Integer.parseInt(tf[0].getText()));
				p.setName(tf[1].getText());
				p.setBirth(tf[2].getText());
				p.setHeight(Double.parseDouble(tf[3].getText()));
				p.setWeight(Double.parseDouble(tf[4].getText()));
				p.setKind(tf[5].getText());
				dba.playerUpdate(p);
				viewBtn.doClick();
				for(int i=0; i<tf.length; i++) {
					tf[i].setText("");
				}
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num=Integer.parseInt(tf[0].getText());
				int result=JOptionPane.showConfirmDialog(null, "���� �����Ͻðڽ��ϱ�?", "����!!", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) {
					dba.playerDelete(num);
					viewBtn.doClick();
					for(int i=0; i<tf.length; i++) {
						tf[i].setText("");
					}
				}
			}
		});

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				int idx = cb.getSelectedIndex();
				String colName = "";
				if (idx == 0) {
					colName = "name";
				} else {
					colName = "kind";
				}
				String word = searchTf.getText();
				ArrayList<Player> arr = dba.playerSearch(colName, word);
				for (Player p1 : arr) {
					ta.append("��ȣ : " + p1.getNum() + "\n");
					ta.append("�̸� : " + p1.getName() + "\n");
					ta.append("���� : " + p1.getBirth() + "\n");
					ta.append("Ű : " + p1.getHeight() + "\n");
					ta.append("������ : " + p1.getWeight() + "\n");
					ta.append("���� : " + p1.getKind() + "\n");
					ta.append("\n");
				}
			}
		});

	}

	class PlayerPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] text = { "��ȣ", "�̸�", "����", "Ű", "������", "����" };

		public PlayerPanel() {
			setLayout(null);
			for (int i = 0; i < text.length; i++) {
				JLabel la = new JLabel(text[i]);
				la.setHorizontalAlignment(JLabel.RIGHT);
				la.setSize(50, 20);
				la.setLocation(30, 50 + i * 20);
				add(la);
				tf[i] = new JTextField(50);
				tf[i].setHorizontalAlignment(JTextField.CENTER);
				tf[i].setSize(150, 20);
				tf[i].setLocation(120, 50 + i * 20);
				add(tf[i]);
			}
			tf[0].setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new PlayerView();
	}
}