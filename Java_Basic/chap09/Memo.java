package chap09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

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
	
	public Memo(String title) {
		setTitle(title);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenu mfile = new JMenu("����");
		
		JMenuItem mOpen = new JMenuItem("����");
		JMenuItem mNew = new JMenuItem("�� ����");
		JMenuItem mSave = new JMenuItem("����");
		JMenuItem mSaveAs = new JMenuItem("�ٸ� �̸����� ����");
		JMenuItem mExit = new JMenuItem("������");
		
		mfile.add(mOpen); mfile.add(mNew); mfile.add(mSave); mfile.add(mSaveAs); mfile.addSeparator(); mfile.add(mExit);
		
		JMenuBar mb=new JMenuBar();
		mb.add(mfile);
		
		setJMenuBar(mb);
		
		ta=new JTextArea();
//		JScrollPane jsp=new JScrollPane(ta); �Ʒ� ���ٰ� ����
		JScrollPane jsp=new JScrollPane();
		jsp.setViewportView(ta);
		add(jsp);
		
		setSize(500, 400);
		setVisible(true);
		
		mOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					JFileChooser jc=new JFileChooser();
					if(jc.showOpenDialog(Memo.this)==JFileChooser.CANCEL_OPTION) return;
					file=jc.getSelectedFile(); //���� ����
					setTitle(file.getName());
					fileRead(file);
//					Scanner sc=new Scanner(file);
//					while(sc.hasNext()) {
//						String str=sc.nextLine();
//						ta.append(str+"\n");
//					}
//					sc.close();
//				} catch (IOException e1) {
//					new MessageBox("����¿���","����� ���� �߻�");
					
//				}
			}
		});
		
		mNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle("���� ����");
				ta.setText("");
			}
		});
		
		mSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getTitle().equals("���� ����")) { //������
					mSaveAs.doClick(); //mSaveAs�� Ŭ���ض�...
				} else { //��������
					fileSave(file);
				}
			}
		});
		
		mSaveAs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jc=new JFileChooser();
				if(jc.showSaveDialog(Memo.this)==JFileChooser.CANCEL_OPTION) return;
				file=jc.getSelectedFile();
				fileSave(file);
//				try {
//					FileWriter fw=new FileWriter(file);
//					fw.write(ta.getText());
//					fw.close();
//				} catch (IOException e1) {
//					new MessageBox("����¿���","����� ���� �߻�");
//				}
			}
		});
		
		mExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
//				System.exit(0);
			}
		});
	}
	

	private void fileRead(File f) {
		FileReader fr;
		try {
			fr = new FileReader(f);
			StringWriter sw=new StringWriter();
			while (true) {
				int ch = fr.read();
				if (ch == -1)	break;
				sw.write(ch);
			}
			ta.setText(sw.toString());
			sw.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void fileSave(File f) {
		PrintStream ps;
		try {
			ps=new PrintStream(f);
			ps.println(ta.getText());
			ps.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static void main(String[] args) {
		new Memo("���� ����");
	}

}
