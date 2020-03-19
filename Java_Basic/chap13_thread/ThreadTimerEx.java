package chap13_thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread extends Thread{
	private JLabel timerLabel;	
	boolean flag=true;
	public TimerThread(JLabel timerLabel) {
		this.timerLabel=timerLabel;
	}
	@Override
	public void run() {
		int n=0;
		while(flag) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}


public class ThreadTimerEx extends JFrame{
	
	public ThreadTimerEx() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		

		
		JLabel timerLabel=new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		c.add(timerLabel);
		JButton btnStart=new JButton("Start");
		JButton btnStop=new JButton("Stop");
		c.add(btnStart);
		c.add(btnStop);
		
		TimerThread th=new TimerThread(timerLabel);
		th.start();
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TimerThread th=new TimerThread(timerLabel);
				th.flag=true;
				th.start();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.flag=false;
			}
		});
		
		
		
		setSize(400, 170);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}

}
