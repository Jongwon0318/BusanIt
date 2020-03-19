package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingFile_FileChoice extends JFrame implements ActionListener {

	private JTextField tf;
	private JTextArea ta;

	public SwingFile_FileChoice() {
		super("SwingFIle_FileChoice");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf = new JTextField(20);
		JButton btnRead = new JButton("�б�");
		JButton btnWrite = new JButton("����");
		ta = new JTextArea(20, 40);
		JScrollPane jsp = new JScrollPane(ta);

		add(tf);
		add(btnRead);
		add(btnWrite);
		add(jsp);

		tf.setEnabled(false);
		btnRead.addActionListener(this);
		btnWrite.addActionListener(this);

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();

		if (str.equals("�б�")) {
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(SwingFile_FileChoice.this) == JFileChooser.CANCEL_OPTION) {
				return;// ��ҹ�ư ó��
			} else {
				File f = fc.getSelectedFile(); // ���õ������� ��ο� �̸�
				String fileName = f.getName(); // ���� �̸�
				tf.setText(fileName);
				ta.setText("");
				try {
					Scanner sc = new Scanner(f);
					while (sc.hasNext()) {
						ta.append(sc.nextLine() + "\n");
					}
					sc.close();
				} catch (FileNotFoundException e1) {
					new MessageBox("���ÿ���!!", "������ ã�� �� �����ϴ�.");
				}
			}
		} else {
			JFileChooser fc = new JFileChooser();
			if (fc.showSaveDialog(SwingFile_FileChoice.this) == JFileChooser.CANCEL_OPTION) {
				return;// ��ҹ�ư ó��
			}
			File f = fc.getSelectedFile();
			String fileName = f.getName();
			tf.setText(fileName);

			try {
				FileWriter fw = new FileWriter(f);
				fw.write(ta.getText());
				fw.close();
			} catch (IOException e1) {
				new MessageBox("����¿���!!", "������ �߻��Ͽ� �����Ҽ�����.");
			}
		}
	}

	public static void main(String[] args) {
		new SwingFile_FileChoice();
	}
}