package chap09;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridTest extends JFrame implements ActionListener {
	JTextField jname, jaddr, jage, tf;
	JButton btn1;

	public GridTest() {
		super("GridLayout");
		setLayout(new GridLayout(4, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JLabel("이름"));
		jname = new JTextField();
		add(jname);

		add(new JLabel("주소"));
		jaddr = new JTextField();
		add(jaddr);

		add(new JLabel("나이"));
		jage = new JTextField();
		add(jage);

		btn1 = new JButton("확인");
		add(btn1);

		tf = new JTextField();
		add(tf);

		btn1.addActionListener(this);
		jname.addActionListener(this);
		jaddr.addActionListener(this);
		jage.addActionListener(this);

		setSize(600, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jname) {
			tf.setText("이름 : " + jname.getText());
		} else if (obj == jaddr) {
			tf.setText("주소 : " + jaddr.getText());
		} else if (obj == jage) {
			tf.setText("나이 : " + jage.getText());
		} else if (obj == btn1) {
			tf.setText("이름 : " + jname.getText() + " 주소 : " + jaddr.getText() + " 나이 : " + jage.getText());
		}
	}

	public static void main(String[] args) {
		new GridTest();
	}
}
