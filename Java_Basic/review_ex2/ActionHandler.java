package review_ex2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ActionHandler implements ActionListener{
	JTextField tf1,tf2;
	JButton btn1,btn2;
	
	ActionHandler(JTextField tf1, JTextField tf2, JButton btn1, JButton btn2){
		this.tf1=tf1;
		this.tf2=tf2;
		this.btn1=btn1;
		this.btn2=btn2;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Encryption")) {
			String str1 = Encryptor_Decryptor.encrypt(tf1.getText());
			tf2.setText(str1);
			btn2.setEnabled(true);
		} else {
			if (tf1.getText().equals(tf2.getText())) {
				btn2.setEnabled(false);
			} else {
				String str2 = Encryptor_Decryptor.decrypt(tf2.getText());
				tf2.setText(str2);
			}
		}
	}

}
