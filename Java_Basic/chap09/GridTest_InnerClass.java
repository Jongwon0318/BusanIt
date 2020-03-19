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

	class ActionHandler implements ActionListener{//���� Ŭ����
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
		
	}
}
