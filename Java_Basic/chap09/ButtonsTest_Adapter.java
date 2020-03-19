package chap09;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonsTest_Adapter extends Frame implements ActionListener {
	public ButtonsTest_Adapter() {
//		setTitle("��ư����");
		super("��ư����11");
		setLayout(new FlowLayout());

		Button b1 = new Button("��ư1"); // Component
		Button b2 = new Button("��ư2");
		Button b3 = new Button("��ư3");
		add(b1); // Attach
		add(b2);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setSize(300, 400);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if (str.equals("��ư1")) {
			System.out.println("��ư1Ŭ��");
			setBackground(Color.yellow);
		}
		if (str.equals("��ư2")) {
			System.out.println("��ư2Ŭ��");
			setBackground(Color.PINK);
		}
		if (str.equals("��ư3")) {
			System.out.println("��ư3Ŭ��");
			setBackground(Color.MAGENTA);
		}
	}

	public static void main(String[] args) {
		new ButtonsTest_Adapter();
	}
}