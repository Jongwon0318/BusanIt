package review_ex2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Memo extends JFrame {
	JTextArea ta;
	File file;
	
	public Memo() {
		setTitle("제목 없음");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		JMenu me = new JMenu("파일");
		mb.add(me);

		JMenuItem open = new JMenuItem("열기");
		JMenuItem newF = new JMenuItem("새 파일");
		JMenuItem save = new JMenuItem("저장");
		JMenuItem saveAs = new JMenuItem("다른 이름으로 저장");
		JMenuItem exit = new JMenuItem("끝내기");

		me.add(open);
		me.add(newF);
		me.add(save);
		me.add(saveAs);
		me.add(exit);
		
		ta = new JTextArea();
		JScrollPane jsp=new JScrollPane(ta);
		
		c.add(mb, BorderLayout.NORTH);
		c.add(jsp, BorderLayout.CENTER);

		setSize(600, 600);
		setVisible(true);

		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					ta.setText("");
					JFileChooser fc = new JFileChooser();			
					if (fc.showOpenDialog(Memo.this) == JFileChooser.CANCEL_OPTION)
						return;
					setTitle(fc.getName(fc.getSelectedFile()));
					Scanner sc=new Scanner(fc.getSelectedFile());
					while(sc.hasNextLine()) {
						ta.append(sc.nextLine()+"\n");
					}
					sc.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});

		newF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.setText("");
				setTitle("제목 없음");
			}
		});

		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("제목 없음")) {
					saveAs.doClick();
				}else {
					save();
				}
			}
		});
		
		saveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc=new JFileChooser();
				if (fc.showSaveDialog(Memo.this) == JFileChooser.CANCEL_OPTION)
					return;
				file=fc.getSelectedFile();
				save();
			}
		});
		
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void save() {
			try {
				PrintStream ps;
				ps = new PrintStream(file);
				ps.println(ta.getText());
				ps.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}

	public static void main(String[] args) {
		new Memo();
	}
}