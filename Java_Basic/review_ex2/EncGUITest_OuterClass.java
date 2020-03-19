package review_ex2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EncGUITest_OuterClass extends JFrame {
	JTextField tf1, tf2;
	JButton btn1, btn2;

	public EncGUITest_OuterClass() {
		super("Encryptor/Decryptor");
		setLayout(new GridLayout(3, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		JPanel p = new JPanel();
		btn1 = new JButton("Encryption");
		btn2 = new JButton("Decryption");
		p.add(btn1);
		p.add(btn2);

		add(tf1);
		add(tf2);
		add(p);

		ActionHandler ah=new ActionHandler(tf1,tf2,btn1,btn2);
		btn1.addActionListener(ah);
		btn2.addActionListener(ah);

		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EncGUITest_OuterClass();

	}

}
