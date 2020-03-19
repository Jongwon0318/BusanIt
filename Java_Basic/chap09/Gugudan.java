package chap09;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gugudan extends Frame implements ActionListener {
	
	TextField tf;
	TextArea ta;
	
	public Gugudan() {
		setTitle("구구단");
		setLayout(new FlowLayout());
		tf=new TextField(12);
		Button dan=new Button("실행");
		ta=new TextArea(10,20);
		
		add(tf);
		add(dan);
		add(ta);
		
		dan.addActionListener(this);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Gugudan();
	}

	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		int dan=Integer.parseInt(tf.getText());
		for(int i=1; i<10; i++) {
			ta.append(dan+"*"+i+"="+dan*i+"\n"); 
		}
	}

}
