package chap13_thread;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadFinishFlagEx_Runnable extends JFrame implements Runnable {
	private boolean flag=false;
	private Container c;
	private JLabel label;
	
	public ThreadFinishFlagEx_Runnable() {
		setTitle("ThreadFinishFlagEx_Runnable ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(null);

		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				flag=true;
			}
		});

		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void run() {
		while (true) {
			int x = (int) (Math.random() * c.getWidth());
			int y = (int) (Math.random() * c.getHeight());
			JLabel label = new JLabel("java");
			label.setSize(80, 30);
			label.setLocation(x, y);
			c.add(label);
			c.repaint();
			if(flag==true) {
				c.removeAll();
				label = new JLabel("finish");
				label.setSize(80, 30);
				label.setLocation(100, 100);
				label.setForeground(Color.RED);
				c.add(label);
				c.repaint();
				return;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

	public static void main(String[] args) {
		ThreadFinishFlagEx_Runnable tffer=new ThreadFinishFlagEx_Runnable();
		Thread th=new Thread(tffer);
		th.start();
	}
}
