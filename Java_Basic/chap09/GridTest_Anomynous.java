package chap09;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridTest_Anomynous extends JFrame {
	JTextField jname, jaddr, jage, tf;
	JButton btn1;

	public GridTest_Anomynous() {
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
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tf.setText("�̸� : "+jname.getText()+" �ּ� : "+jaddr.getText()+" ���� : "+jage.getText());
			}
		});
		jname.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("�̸� : "+jname.getText());
			}
		});
		jaddr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("�ּ� : "+jaddr.getText());			
			}
		});
		jage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("���� : "+jage.getText());
			}
		});
		
		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridTest_Anomynous();
	}
}
