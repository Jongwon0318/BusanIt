package chap11_book;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex11_13 extends JFrame{
	private JLabel lb;
	private String[] fruits={"apple","banana","kiwi","mango"};
	private ImageIcon [] images= {
			new ImageIcon("src\\images\\apple.jpg"),
			new ImageIcon("src\\images\\banana.jpg"),
			new ImageIcon("src\\images\\kiwi.jpg"),
			new ImageIcon("src\\images\\mango.jpg")
	};
	public Ex11_13() {
		super("Ex11_13");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		JComboBox cbx=new JComboBox(fruits);
		lb=new JLabel();
		
		add(cbx); add(lb);
		
		setSize(300, 300);
		setVisible(true);
		
		cbx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb=(JComboBox<String>)e.getSource();
				int index=cb.getSelectedIndex();
				lb.setIcon(images[index]);
			}
		});
	}
	
	public static void main(String[] args) {
		new Ex11_13();
	}

}
