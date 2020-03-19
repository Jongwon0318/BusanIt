package chap13_thread;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ClockT extends Thread{
	private JLabel clockLabel;
	boolean flag=true;
	public ClockT(JLabel clockLabel) {
		this.clockLabel=clockLabel;
	}	
	@Override
	public void run() {
		while(flag) {
			Calendar c=Calendar.getInstance();
			int hour=c.get(Calendar.HOUR_OF_DAY);
			int min=c.get(Calendar.MINUTE);
			int sec=c.get(Calendar.SECOND);
			String clockStr=hour+":"+min+":"+sec;
			clockLabel.setText(clockStr);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ClockMain extends JFrame {
	ClockT timerThread;
	public ClockMain() {
		setTitle("Clock");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c=getContentPane();
		JLabel clock = new JLabel("");
		clock.setFont(new Font("TimesRoman",Font.ITALIC,50));
		clock.setHorizontalAlignment(JLabel.CENTER);
		
		c.add(clock,BorderLayout.CENTER);
		JButton btnStart=new JButton("Start");
		JButton btnStop=new JButton("Stop");
		c.add(btnStart,BorderLayout.NORTH);
		c.add(btnStop,BorderLayout.SOUTH);
		timerThread=new ClockT(clock);
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timerThread=new ClockT(clock);
				timerThread.flag=true;
				timerThread.start();
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timerThread.flag=false;
			}
		});
		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ClockMain();
	}

}