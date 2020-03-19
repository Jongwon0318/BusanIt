package review_ex2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox extends JFrame{
	public MessageBox(String str1, String str2) {
		super(str1);
		setLayout(new FlowLayout());
		JLabel content=new JLabel(str2);
		JButton btn=new JButton("´Ý±â");
		add(content); add(btn);
		
		setSize(150, 150);
		setVisible(true);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
}
