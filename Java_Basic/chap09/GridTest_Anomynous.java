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
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tf.setText("이름 : "+jname.getText()+" 주소 : "+jaddr.getText()+" 나이 : "+jage.getText());
			}
		});
		jname.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("이름 : "+jname.getText());
			}
		});
		jaddr.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("주소 : "+jaddr.getText());			
			}
		});
		jage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tf.setText("나이 : "+jage.getText());
			}
		});
		
		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridTest_Anomynous();
	}
}
