package chap09;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridTest_InnerClass extends JFrame{
	JTextField jname, jaddr, jage, tf;
	JButton btn1;

	public GridTest_InnerClass() {
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
		
		ActionHandler ahd=new ActionHandler();
		btn1.addActionListener(ahd);
		jname.addActionListener(ahd);
		jaddr.addActionListener(ahd);
		jage.addActionListener(ahd);
		
		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridTest_InnerClass();
	}

	class ActionHandler implements ActionListener{//내부 클래스
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
		
	}
}
