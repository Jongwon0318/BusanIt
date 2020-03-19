package chap09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ActionH implements ActionListener {
	JTextField jname, jaddr, jage, tf;
	JButton btn1;

	public ActionH(JButton btn1, JTextField jname, JTextField jaddr, JTextField jage, JTextField tf) {
		this.btn1=btn1; 
		this.jname=jname; 
		this.jaddr=jaddr; 
		this.jage=jage; 
		this.tf=tf;
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

}
