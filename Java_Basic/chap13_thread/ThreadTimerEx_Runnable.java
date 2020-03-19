package chap13_thread;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerEx_Runnable extends JFrame implements Runnable{
	JLabel timerLabel;
	public ThreadTimerEx_Runnable() {
		setTitle("Thread를 상속받은 타이머 스레드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		
		timerLabel=new JLabel();
		timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
		c.add(timerLabel);
		
		setSize(400, 170);
		setVisible(true);
	}
	
	@Override
	public void run() {
		int n=0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTimerEx_Runnable tter=new ThreadTimerEx_Runnable();
		Thread th=new Thread(tter);
		th.start();
	}

	
}
