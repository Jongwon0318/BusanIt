package chap09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Converter extends JFrame implements ActionListener {
//1km=0.62mile
	private JTextField tf1, tf2;

	public Converter() {
		super("마일 변환기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		tf1 = new JTextField(10);
		tf2 = new JTextField(10);

		JButton jb1 = new JButton("변환");
		jb1.setSize(300, 100);

		p1.add(new JLabel("km입력"));
		p1.add(tf1);
		p2.add(new JLabel("결과"));
		p2.add(tf2);

		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER, jb1);
		add(BorderLayout.SOUTH, p2);

		tf1.addActionListener(this);
		jb1.addActionListener(this);

		setSize(300, 150);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int num = Integer.parseInt(tf1.getText());
			tf2.setText(String.valueOf(num * 0.62));
		}catch(NumberFormatException a) {
			tf2.setText("숫자를 입력하세요.");
		}	
	}

	public static void main(String[] args) {
		new Converter();
	}
}
