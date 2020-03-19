package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingFile extends JFrame implements ActionListener {

	private JTextField tf;
	private JTextArea ta;

	public SwingFile() {
		super("SwingFIle");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(20);
		JButton btnRead = new JButton("읽기");
		JButton btnWrite = new JButton("쓰기");
		ta = new JTextArea(20, 40);
		JScrollPane jsp = new JScrollPane(ta);

		add(tf);
		add(btnRead);
		add(btnWrite);
		add(jsp);

		btnRead.addActionListener(this);
		btnWrite.addActionListener(this);

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fileName = String.valueOf(tf.getText());
		File dir = new File("src\\chap09");
		File file = new File(dir, fileName);
		String str = e.getActionCommand();
		
		if (str.equals("읽기")) {
			ta.setText("");
			try {
				Scanner sc = new Scanner(file);
				while (sc.hasNext()) {
					ta.append(sc.nextLine() + "\n");
				}
			} catch (FileNotFoundException f1) {
				new MessageBox("읽기오류!!", "파일이 없어요");
			}
		} else {
			FileWriter fw;
			try {
				fw = new FileWriter(file);
				fw.write(ta.getText());
				fw.close();
			} catch (IOException e1) {
				new MessageBox("파일오류!!", "파일이름이 없어요");
			}
		}
	}

	public static void main(String[] args) {
		new SwingFile();
	}
}