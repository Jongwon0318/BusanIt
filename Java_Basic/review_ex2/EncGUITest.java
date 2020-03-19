package review_ex2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EncGUITest extends JFrame{
	public EncGUITest() {
		super("Encryptor/Decryptor");
		setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField tf1=new JTextField(10);
		JTextField tf2=new JTextField(10);
		JPanel p=new JPanel();
		JButton btn1=new JButton("Encryption");
		JButton btn2=new JButton("Decryption");
		p.add(btn1); p.add(btn2);
		
		add(tf1); 
		add(tf2);
		add(p);
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str=Encryptor_Decryptor.encrypt(tf1.getText());
				tf2.setText(str);
				btn2.setEnabled(true);
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tf1.getText().equals(tf2.getText())) {
					btn2.setEnabled(false);
				}else {
					String str=Encryptor_Decryptor.decrypt(tf2.getText());
					tf2.setText(str);
				}
			}
		});
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EncGUITest();
		
	}

}
