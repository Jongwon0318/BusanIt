package review_Player;

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
	JTextArea ta;
	JButton insertBtn, viewBtn, updateBtn, deleteBtn, searchBtn;
	JTextField searchTf;
	JComboBox<String> cb;
	String[] text = { "번호", "이름", "생일", "키", "몸무게", "종목" };
	JTextField[] tf = new JTextField[6];
	Connection con;

	public PlayerSwing() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "HR";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		setTitle("PlayerSwing");
		Container c = getContentPane();
		c.setLayout(new GridLayout(2, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		c.add(new PlayerPanel());

		ta = new JTextArea();
		ta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					int num = Integer.parseInt(ta.getSelectedText().trim());
					tf[0].setText(num + "");
					String sql = "SELECT * FROM Player WHERE num=" + num;
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery(sql);
					while (res.next()) {
						tf[1].setText(res.getString("name"));
						tf[2].setText(res.getString("birth"));
						tf[3].setText(res.getDouble("height") + "");
						tf[4].setText(res.getDouble("weight") + "");
						tf[5].setText(res.getString("kind"));
					}
				} catch (NullPointerException n) {
					JOptionPane.showMessageDialog(null, "번호를 드래그하여 선택하세요.");
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "번호를 드래그하여 선택하세요.");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		JScrollPane jsp = new JScrollPane(ta);
		c.add(jsp);

		insertBtn = new JButton("추가");
		viewBtn = new JButton("보기");
		updateBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");

		JPanel p1 = new JPanel();
		p1.add(insertBtn);
		p1.add(viewBtn);
		p1.add(updateBtn);
		p1.add(deleteBtn);
		c.add(p1);

		searchTf = new JTextField(12);
		cb = new JComboBox<String>();
		cb.addItem("이름");
		cb.addItem("종목");
		searchBtn = new JButton("검색");
		JPanel p2 = new JPanel();
		p2.add(cb);
		p2.add(searchTf);
		p2.add(searchBtn);
		c.add(p2);

		setSize(600, 450);
		setVisible(true);

		insertBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "INSERT INTO Player VALUES (player_seq.NEXTVAL, ?, ?, ?, ?, ?)";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, tf[1].getText());
					ps.setString(2, tf[2].getText());
					ps.setDouble(3, Double.parseDouble(tf[3].getText()));
					ps.setDouble(4, Double.parseDouble(tf[4].getText()));
					ps.setString(5, tf[5].getText());
					ps.executeUpdate();
					for (int i = 0; i < tf.length; i++) {
						tf[i].setText("");
					}
					viewBtn.doClick();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		viewBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				try {
					String sql = "SELECT * FROM Player ORDER BY num";
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery(sql);
					while (res.next()) {
						ta.append("번호 : " + res.getInt("num") + "\n");
						ta.append("이름 : " + res.getString("name") + "\n");
						ta.append("생일 : " + res.getString("birth") + "\n");
						ta.append("키 : " + res.getDouble("height") + "\n");
						ta.append("몸무게 : " + res.getDouble("weight") + "\n");
						ta.append("종목 : " + res.getString("kind") + "\n");
						ta.append("\n");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(tf[0].getText());
					String sql = "UPDATE Player SET name = ?, birth = ?, height = ?, weight = ?, kind = ? WHERE num="
							+ num;
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, tf[1].getText());
					ps.setString(2, tf[2].getText());
					ps.setDouble(3, Double.parseDouble(tf[3].getText()));
					ps.setDouble(4, Double.parseDouble(tf[4].getText()));
					ps.setString(5, tf[5].getText());
					ps.executeUpdate();
					for (int i = 0; i < tf.length; i++) {
						tf[i].setText("");
					}
					viewBtn.doClick();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "주의!!", JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int num = Integer.parseInt(tf[0].getText());
						String sql = "DELETE FROM Player WHERE num=" + num;
						Statement st = con.createStatement();
						st.executeUpdate(sql);
						for (int i = 0; i < tf.length; i++) {
							tf[i].setText("");
						}
						viewBtn.doClick();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ta.setText("");
					String colName = "";
					if (cb.getSelectedIndex() == 0) {
						colName = "name";
					} else {
						colName = "kind";
					}
					String sql = "SELECT * FROM Player WHERE " + colName + " LIKE '%" + searchTf.getText() + "%'";
					Statement st = con.createStatement();
					ResultSet res = st.executeQuery(sql);
					while (res.next()) {
						ta.append("번호 : " + res.getInt("num") + "\n");
						ta.append("이름 : " + res.getString("name") + "\n");
						ta.append("생일 : " + res.getString("birth") + "\n");
						ta.append("키 : " + res.getDouble("height") + "\n");
						ta.append("몸무게 : " + res.getDouble("weight") + "\n");
						ta.append("종목 : " + res.getString("kind") + "\n");
						ta.append("\n");
					}
					searchTf.setText("");
				} catch (SQLException s1) {
					s1.printStackTrace();
				}
			}
		});

	}

	class PlayerPanel extends JPanel {
		public PlayerPanel() {
			setLayout(null);
			for (int i = 0; i < text.length; i++) {
				JLabel lb = new JLabel(text[i]);
				lb.setHorizontalAlignment(JLabel.RIGHT);
				lb.setSize(50, 20);
				lb.setLocation(30, 50 + i * 20);
				add(lb);
				tf[i] = new JTextField(10);
				tf[i].setHorizontalAlignment(JTextField.CENTER);
				tf[i].setSize(140, 20);
				tf[i].setLocation(90, 50 + i * 20);
				add(tf[i]);
			}
			tf[0].setEnabled(false);
		}
	}

	public static void main(String[] args) {
		new PlayerSwing();
	}

}
