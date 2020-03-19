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

		add(new JLabel("�̸�"));
		jname = new JTextField();
		add(jname);

		add(new JLabel("�ּ�"));
		jaddr = new JTextField();
		add(jaddr);

		add(new JLabel("����"));
		jage = new JTextField();
		add(jage);

		btn1 = new JButton("Ȯ��");
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
			tf.setText("�̸� : " + jname.getText());
		} else if (obj == jaddr) {
			tf.setText("�ּ� : " + jaddr.getText());
		} else if (obj == jage) {
			tf.setText("���� : " + jage.getText());
		} else if (obj == btn1) {
			tf.setText("�̸� : " + jname.getText() + " �ּ� : " + jaddr.getText() + " ���� : " + jage.getText());
		}
	}

	public static void main(String[] args) {
		new GridTest();
	}
}
