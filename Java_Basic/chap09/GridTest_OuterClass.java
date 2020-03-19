package chap09;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridTest_OuterClass extends JFrame{
	JTextField jname, jaddr, jage, tf;
	JButton btn1;

	public GridTest_OuterClass() {
		super("InnerGridLayout");
		setLayout(new GridLayout(4, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JLabel("이름"));
		jname = new JTextField();
		add(jname);

		add(new JLabel("주소"));
		jaddr = new JTextField();
		add(jaddr);

		add(new JLabel("나이"));
		jage = new JTextField();
		add(jage);

		btn1 = new JButton("확인");
		add(btn1);

		tf = new JTextField();
		add(tf);
		
		ActionH ah=new ActionH(btn1, jname, jaddr, jage, tf);
		btn1.addActionListener(ah);
		jname.addActionListener(ah);
		jaddr.addActionListener(ah);
		jage.addActionListener(ah);

		setSize(600, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridTest_OuterClass();
	}
}
