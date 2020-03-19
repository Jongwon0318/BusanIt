package chap09;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonsTest extends JFrame implements ActionListener {
	public JButtonsTest() {
		super("SwingButtons");
		setLayout(new FlowLayout());
		JButton btn1 = new JButton("Button1");
		JButton btn2 = new JButton("Button2");
		JButton btn3 = new JButton("Button3");
		add(btn1);
		add(btn2);
		add(btn3);

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		setSize(300, 400);
		setVisible(true);
		// 이벤트 핸들러 작성하여 btn1을 클릭하면 콘솔창에 버튼이 클릭되었습니다 출력
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("Button1")) {
			System.out.println("버튼1이 클릭되었습니다.");
			setSize(400, 500);
			getContentPane().setBackground(Color.magenta);
		}
		if (str.equals("Button2")) {
			System.out.println("버튼2가 클릭되었습니다.");
			setSize(500, 600);
			getContentPane().setBackground(Color.blue);
		}
		if (str.equals("Button3")) {
			System.out.println("버튼3이 클릭되었습니다.");
			setSize(600, 700);
			getContentPane().setBackground(Color.CYAN);
		}
	}

	public static void main(String[] args) {
		new JButtonsTest();
	}

}
