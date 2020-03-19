package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox extends JFrame{
	//NullPointerException
	
	public MessageBox(String title, String msg){
		super(title);
		setLayout(new FlowLayout());
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 프로그램을 모두 끝내버림
		JButton closeBtn=new JButton("닫기");
		JLabel lbl=new JLabel(msg);
		add(lbl);
		add(closeBtn);
		
		setSize(300, 100);
		setVisible(true);
		
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
	}
	
}