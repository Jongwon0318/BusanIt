package chap09.player;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PlayerSwing extends JFrame {
	JTextField[] tf = new JTextField[6];
	Connection con;
	JTextArea ta;

	public PlayerSwing() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "HR";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

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
					tf[0].setText(num + "");
					String sql = "SELECT * FROM Player WHERE num=" + num;
					Statement st;
					st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					if (rs.next()) {
						tf[1].setText(rs.getString("name"));
						tf[2].setText(rs.getString("birth"));
						tf[3].setText(rs.getDouble("height") + "");
						tf[4].setText(rs.getDouble("weight") + "");
						tf[5].setText(rs.getString("kind"));
					}
				} catch (NullPointerException n) {
					JOptionPane.showMessageDialog(null, "��ȣ�� �巡���Ͽ� �����ϼ���.");
				} catch (NumberFormatException f) {
					JOptionPane.showMessageDialog(null, "��ȣ�� �巡���Ͽ� �����ϼ���.");
				} catch (SQLException e2) {
					e2.printStackTrace();
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
				String sql = "INSERT INTO Player VALUES(Player_seq.NEXTVAL,?,?,?,?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql); // ����ǥ�� �����Ѵ�.
					ps.setString(1, tf[1].getText());
					ps.setString(2, tf[2].getText());
					ps.setDouble(3, Double.parseDouble(tf[3].getText()));
					ps.setDouble(4, Double.parseDouble(tf[4].getText()));
					ps.setString(5, tf[5].getText());
					ps.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < tf.length; i++) {
					tf[i].setText("");
				}
				viewBtn.doClick();
				clearText();
			}
		});
		
		tf[5].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO Player VALUES(Player_seq.NEXTVAL,?,?,?,?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql); // ����ǥ�� �����Ѵ�.
					ps.setString(1, tf[1].getText());
					ps.setString(2, tf[2].getText());
					ps.setDouble(3, Double.parseDouble(tf[3].getText()));
					ps.setDouble(4, Double.parseDouble(tf[4].getText()));
					ps.setString(5, tf[5].getText());
					ps.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				for (int i = 0; i < tf.length; i++) {
					tf[i].setText("");
				}
				viewBtn.doClick();
				clearText();				
			}
		});
		
		viewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql = "SELECT * FROM Player ORDER BY num";
				try {
					ta.setText("");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						ta.append("��ȣ : " + rs.getInt("num") + "\n");
						ta.append("�̸� : " + rs.getString("name") + "\n");
						ta.append("���� : " + rs.getString("birth") + "\n");
						ta.append("Ű : " + rs.getDouble("height") + "\n");
						ta.append("������ : " + rs.getDouble("weight") + "\n");
						ta.append("���� : " + rs.getString("kind") + "\n\n");
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String sql="update player set name=?, birth=?, height=?, weight=?, kind=? where num=?";
				PreparedStatement ps;
				try {
					ps=con.prepareStatement(sql);
					ps.setString(1, tf[1].getText());
					ps.setString(2, tf[2].getText());
					ps.setDouble(3, Double.parseDouble(tf[3].getText()));
					ps.setDouble(4, Double.parseDouble(tf[4].getText()));
					ps.setString(5, tf[5].getText());
					ps.setInt(6, Integer.parseInt(tf[0].getText()));
					ps.executeUpdate();
					viewBtn.doClick();
					clearText();
				}catch(SQLException e1){
					
				}
				
				/*int unum = Integer.parseInt(tf[0].getText());		
					if (!tf[1].getText().equals("")) {
					String colName = "name";
					String content = tf[1].getText();
					String sql = "UPDATE Player" + " SET " + colName + " = '" + content + "' WHERE num= " + unum;
					try {
						Statement st = con.createStatement();
						st.executeUpdate(sql); // Insert, Delete, Update
					} catch (SQLException e4) {
						System.out.println("����");
					}
				}
				if (!tf[2].getText().equals("")) {
					String colName = "birth";
					String content = tf[2].getText();
					String sql = "UPDATE Player" + " SET " + colName + " = '" + content + "' WHERE num= " + unum;
					try {
						Statement st = con.createStatement();
						st.executeUpdate(sql); // Insert, Delete, Update
					} catch (SQLException e4) {
						System.out.println("����");
					}
				}
				if (!tf[3].getText().equals("")) {
					String colName = "height";
					Double content = Double.parseDouble(tf[3].getText());
					String sql = "UPDATE Player" + " SET " + colName + " = " + content + " WHERE num= " + unum;
					try {
						Statement st = con.createStatement();
						st.executeUpdate(sql); // Insert, Delete, Update
					} catch (SQLException e4) {
						System.out.println("����");
					}
				}
				if (!tf[4].getText().equals("")) {
					String colName = "weight";
					Double content = Double.parseDouble(tf[4].getText());
					String sql = "UPDATE Player" + " SET " + colName + " = " + content + " WHERE num= " + unum;
					try {
						Statement st = con.createStatement();
						st.executeUpdate(sql); // Insert, Delete, Update
					} catch (SQLException e4) {
						System.out.println("����");
					}
				}
				if (!tf[5].getText().equals("")) {
					String colName = "kind";
					String content = tf[5].getText();
					String sql = "UPDATE Player" + " SET " + colName + " = '" + content + "' WHERE num= " + unum;
					try {
						Statement st = con.createStatement();
						st.executeUpdate(sql); // Insert, Delete, Update
					} catch (SQLException e4) {
						System.out.println("����");
					}
				}
				viewBtn.doClick();
				clearText();*/
			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dnum = Integer.parseInt(tf[0].getText());
				String sql = "DELETE FROM Player WHERE num=" + dnum;
				try {
					int result=JOptionPane.showConfirmDialog(null, "���� �����ұ��?","Confirm",JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
						Statement st = con.createStatement();
						st.executeUpdate(sql);
						viewBtn.doClick();
						clearText();
					}
				} catch (SQLException e3) {
					System.out.println("�����߻�!! �����Ұ�");
				}
			}
		});

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb.getSelectedIndex() == 0) { //��ġ��
					String sname = searchTf.getText();
					searchName(sname);
					searchTf.setText("");
				} else {
					String skind = searchTf.getText();
					searchKind(skind);
					searchTf.setText("");
				}
			}
		});
		
		searchTf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb.getSelectedIndex() == 0) { //��ġ��
					String sname = searchTf.getText();
					searchName(sname);
					searchTf.setText("");
				} else {
					String skind = searchTf.getText();
					searchKind(skind);
					searchTf.setText("");
				}				
			}
		});
	}

	private void searchName(String sname) {
		String sql = "SELECT * FROM Player WHERE name LIKE '%" + sname + "%'";
		try {
			ta.setText("");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ta.append("��ȣ : " + rs.getInt("num") + "\n");
				ta.append("�̸� : " + rs.getString("name") + "\n");
				ta.append("���� : " + rs.getString("birth") + "\n");
				ta.append("Ű : " + rs.getDouble("height") + "\n");
				ta.append("������ : " + rs.getDouble("weight") + "\n");
				ta.append("���� : " + rs.getString("kind") + "\n\n");
			}
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}

	private void searchKind(String skind) {
		String sql = "SELECT * FROM Player WHERE kind LIKE '%" + skind + "%'";
		try {
			ta.setText("");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				ta.append("��ȣ : " + rs.getInt("num") + "\n");
				ta.append("�̸� : " + rs.getString("name") + "\n");
				ta.append("���� : " + rs.getString("birth") + "\n");
				ta.append("Ű : " + rs.getDouble("height") + "\n");
				ta.append("������ : " + rs.getDouble("weight") + "\n");
				ta.append("���� : " + rs.getString("kind") + "\n\n");
			}
		} catch (SQLException e3) {
			e3.printStackTrace();
		}
	}
	
	private void clearText() {
		for(int i=0; i<tf.length; i++) {
			tf[i].setText("");
		}
	}
	
	private class PlayerPanel extends JPanel {
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
		new PlayerSwing();
	}
}