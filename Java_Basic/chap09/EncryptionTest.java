package chap09;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EncryptionTest extends JFrame {

	public EncryptionTest() {
		super("Encryption/Decryption");
		setLayout(new GridLayout(3, 1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		TextArea ta1 = new TextArea();
		TextArea ta2 = new TextArea();

		JButton btn1 = new JButton("암호화");
		JButton btn2 = new JButton("복호화");

		p1.add(ta1);
		p2.add(ta2);
		p3.add(btn1);
		p3.add(btn2);

		add(p1);
		add(p2);
		add(p3);

		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				char[] arr = ta1.getText().toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == ' ') {
						str += ' ';
					} else {
						str += (char) (arr[i] + 2);
					}
				}
				ta2.setText("");
				ta2.append(str);
				btn2.setEnabled(true);
			}
		});

		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = "";
				char[] arr = ta2.getText().toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] == ' ') {
						str += ' ';
					} else {
						str += (char) (arr[i] - 2);
					}
				}
				if(ta1.getText().equals(ta2.getText())) {
					btn2.setEnabled(false);
				}else {
					ta2.setText("");
					ta2.append(str);
				}
			}
		});
		setSize(500, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new EncryptionTest();
	}

}
