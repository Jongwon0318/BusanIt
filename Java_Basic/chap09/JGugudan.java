package chap09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JGugudan extends JFrame implements ActionListener{
	JTextField jtf;
	JTextArea jta;
	
	public JGugudan() {
		setTitle("J������");
		setLayout(new FlowLayout());
		jtf=new JTextField(12);
		jta=new JTextArea(10,20);
		JScrollPane jsp=new JScrollPane(jta);
		JButton jbt=new JButton("����");
		
		add(jtf);
		add(jbt);
		add(jsp);

		jbt.addActionListener(this);
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JGugudan();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		jta.setText("");
		try {
			int dan=Integer.parseInt(jtf.getText());
			for(int i=1; i<10; i++) {
				jta.append(dan+"*"+i+"="+dan*i+"\n"); //��ũ�ѹٰ� �ڵ������� ������ ����.
			}
		}catch(NumberFormatException nfe){
			jtf.setText("���ڸ� �Է��ϼ���.");
		}	
	
	}

}
