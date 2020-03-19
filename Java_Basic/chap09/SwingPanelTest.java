package chap09;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingPanelTest extends JFrame implements ActionListener{
	private JPanel p1,p2;
	private JButton b1,b2,b3,b4;
	
	public SwingPanelTest() {
		super("SwingTest");
		setLayout(new FlowLayout());
		
		p1= new JPanel();
		p2= new JPanel();
		
		b1=new JButton("패널2보이기");
		b2=new JButton("패널2안보이기");
		b3=new JButton("패널1보이기");
		b4=new JButton("패널1안보이기");
		
		p1.add(b1);
		p1.add(b2);
		p2.add(b3);
		p2.add(b4);
		
		add(p1);
		add(p2);
		
		p1.setBackground(Color.BLUE);
		p2.setBackground(Color.MAGENTA);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		setSize(400,400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str=e.getActionCommand();
		if(str.equals("패널2보이기")) {
			p2.setVisible(true);
		}
		if(str.equals("패널2안보이기")) {
			p2.setVisible(false);
		}
		if(str.equals("패널1보이기")) {
			p1.setVisible(true);
		}
		if(str.equals("패널1안보이기")) {
			p1.setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new SwingPanelTest();
	}

}
