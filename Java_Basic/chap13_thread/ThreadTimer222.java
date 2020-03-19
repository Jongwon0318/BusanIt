package chap13_thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class TimerThread1 extends Thread{
	private JLabel timerLabel;	
	boolean flag=true;
	int n;
	public TimerThread1(JLabel timerLabel) {
		this.timerLabel=timerLabel;
		n=Integer.parseInt( timerLabel.getText())+1;
	}
	@Override
	public void run() {
	
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

public class ThreadTimer222 extends JFrame{
	TimerThread1 th;
	public ThreadTimer222() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new BorderLayout());
		
		JLabel timerLabel=new JLabel("0");
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		c.add(timerLabel,BorderLayout.CENTER);
		JButton btnStart=new JButton("Start");
		JButton btnStop=new JButton("Stop");
		c.add(btnStart,BorderLayout.NORTH);
		c.add(btnStop,BorderLayout.SOUTH);
		
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th=new TimerThread1(timerLabel);
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
		
		setSize(300, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ThreadTimer222();
	}

}
