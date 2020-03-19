package review_ex3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockMain extends JFrame{
	JLabel label;
	ClockThread ct;
	public ClockMain() {
		setTitle("Clock");
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton startBtn=new JButton("Start");
		JButton stopBtn=new JButton("Stop");
		label=new JLabel();
		
		c.add(startBtn,BorderLayout.NORTH);
		c.add(stopBtn,BorderLayout.SOUTH);
		c.add(label,BorderLayout.CENTER);
		
		setSize(300, 200);
		setVisible(true);
		
		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ct=new ClockThread();
				ct.flag=true;
				ct.start();
			}
		});
		
		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ct.flag=false;			
			}
		});
	}
	
	class ClockThread extends Thread{
		String str;
		boolean flag;
		public ClockThread() {
	
		}
		@Override
		public void run() {
			while(flag) {
				Calendar ca=Calendar.getInstance();
				int hour=ca.get(Calendar.HOUR_OF_DAY);
				int min=ca.get(Calendar.MINUTE);
				int sec=ca.get(Calendar.SECOND);
				str=hour+" : "+min+" : "+sec;
				label.setText(str);
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setSize(150, 80);
				label.setFont(new Font("TimesNewRoman",Font.ITALIC,50));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ClockMain();
	}

}
