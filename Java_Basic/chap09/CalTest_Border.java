package chap09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//JFrame은 기본 레이아웃은 BorderLayout
//JPanel의 기본 레이아웃은 FlowLayout
public class CalTest_Border extends JFrame implements ActionListener {
	private JTextField tf1, tf2, tf3;

	public CalTest_Border() {
		setTitle("BorderLayoutTest");
//		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();
//		p1.setLayout(new FlowLayout());
		JPanel p2 = new JPanel();
//		p2.setLayout(new FlowLayout());
		JPanel p3 = new JPanel();
//		p3.setLayout(new FlowLayout());
		tf1 = new JTextField(5);
		tf2 = new JTextField(5);
		tf3 = new JTextField(20);
		JButton jb1 = new JButton("+");
		JButton jb2 = new JButton("-");
		JButton jb3 = new JButton("*");
		JButton jb4 = new JButton("/");
		p1.add(new JLabel("숫자1"));
		p1.add(tf1);
		p1.add(new JLabel("숫자2"));
		p1.add(tf2);

		p2.add(jb1);
		p2.add(jb2);
		p2.add(jb3);
		p2.add(jb4);

		p3.add(new JLabel("결과"));
		p3.add(tf3);

		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER, p2);
		add(BorderLayout.SOUTH, p3);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
		
		setSize(300, 150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalTest_Border();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		try {
			int num1 = Integer.parseInt(tf1.getText());
		} catch (NumberFormatException nfe) {
			tf1.setText("숫자입력");
		}
		try {
			int num2 = Integer.parseInt(tf2.getText());
		} catch (NumberFormatException nfe) {
			tf2.setText("숫자입력");
		}
		try {
			int num1 = Integer.parseInt(tf1.getText());
			int num2 = Integer.parseInt(tf2.getText());
			switch (str) {
			case "+":
				tf3.setText(num1 + "+" + num2 + "=" + (num1 + num2)); break;
			case "-":
				tf3.setText(num1 + "-" + num2 + "=" + (num1 - num2)); break;
			case "*":
				tf3.setText(num1 + "*" + num2 + "=" + (num1 * num2)); break;
			case "/":
				tf3.setText(num1 + "/" + num2 + "=" + (num1 / num2)); 
			}
		} catch (NumberFormatException nfe) {
			tf3.setText("숫자 입력 오류 발생");
		}
	}

}
