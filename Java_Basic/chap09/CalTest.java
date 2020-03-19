package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings({ "serial", "unused" })
public class CalTest extends JFrame implements ActionListener {
//	private JTextField tr1;
//	private JTextField tr2;
//	private JTextField tr3;
//	private JButton jb1;
//	private JButton jb2;
//	private JButton jb3;
//	private JButton jb4;
//	private JPanel p1;
//	private JPanel p2;
//	private JPanel p3;
	private JTextField tr1, tr2, tr3;
	private JButton jb1, jb2, jb3, jb4;
	private JPanel p1, p2, p3;

	public CalTest() {
		setTitle("����");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���α׷��� ������ �����Ű�� ����(���α׷� â�� ���� ��
		p1 = new JPanel();
		p1.add(new JLabel("����1"));
		tr1 = new JTextField(5);
		p1.add(tr1);
		p1.add(new JLabel("����2"));
		tr2 = new JTextField(5);
		p1.add(tr2);

		p2 = new JPanel();
		jb1 = new JButton("+");
		jb2 = new JButton("-");
		jb3 = new JButton("*");
		jb4 = new JButton("/");
		p2.add(jb1);
		p2.add(jb2);
		p2.add(jb3);
		p2.add(jb4);

		p3 = new JPanel();
		p3.add(new JLabel("���"));
		tr3 = new JTextField(13);
		p3.add(tr3);

		add(p1);
		add(p2);
		add(p3);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

		setSize(300, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		try {
			@SuppressWarnings("unused")
			int num1 = Integer.parseInt(tr1.getText());
		} catch (NumberFormatException nfe) {
			tr1.setText("�����Է�");
		}
		try {
			@SuppressWarnings("unused")
			int num2 = Integer.parseInt(tr2.getText());
		} catch (NumberFormatException nfe) {
			tr2.setText("�����Է�");
		}
		try {
			int num1 = Integer.parseInt(tr1.getText());
			int num2 = Integer.parseInt(tr2.getText());
			if (str.equals("+")) { // switch�� ��� ����
				tr3.setText(num1 + "+" + num2 + "=" + (num1 + num2));
//				tr3.setText(num1+num2+"");
//				tr3.setText(String.valueOf(num1+num2));
			}
			if (str.equals("-")) {
				tr3.setText(num1 + "-" + num2 + "=" + (num1 - num2));
			}
			if (str.equals("*")) {
				tr3.setText(num1 + "*" + num2 + "=" + (num1 * num2));
			}
			if (str.equals("/")) {
				tr3.setText(num1 + "/" + num2 + "=" + (num1 / num2));
			}
		} catch (NumberFormatException nfe) {
			tr3.setText("���� �Է� ���� �߻�");
		} catch (ArithmeticException ae) {
			tr3.setText("0���� ���� �� �����ϴ�.");
		}
	}

	public static void main(String[] args) {
		new CalTest();
	}
}