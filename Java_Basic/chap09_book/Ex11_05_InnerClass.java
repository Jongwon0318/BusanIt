package chap09_book;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex11_05_InnerClass  extends JFrame{
	JCheckBox cb1,cb2,cb3;
	JLabel la2;
	int sum;
	
	public Ex11_05_InnerClass(){
		super("üũ�ڽ��� Itemevent");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel la1=new JLabel("��� 100��, �� 500��, ü�� 20000��");
		JPanel p=new JPanel();
		cb1=new JCheckBox("���");
		cb2=new JCheckBox("��");
		cb3=new JCheckBox("ü��");
		la2=new JLabel("���� 0�� �Դϴ�.");
		add(la1); 
		p.add(cb1); p.add(cb2); p.add(cb3);
		add(p);
		add(la2);
		
		ItemHandler ih=new ItemHandler();
		cb1.addItemListener(ih);
		cb2.addItemListener(ih);
		cb3.addItemListener(ih);
		
		setSize(250, 300);
		setVisible(true);
	}
	
	class ItemHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			JCheckBox cb=(JCheckBox) e.getSource();
			if(cb.isSelected()==true) {
				if(e.getItem().equals(cb1)) {
					sum+=100;
				}else if(e.getItem().equals(cb2)) {
					sum+=500;
				}else if(e.getItem().equals(cb3)) {
					sum+=20000;
				}
			}else {
				if(e.getItem().equals(cb1)) {
					sum-=100;
				}else if(e.getItem().equals(cb2)) {
					sum-=500;
				}else if(e.getItem().equals(cb3)) {
					sum-=20000;
				}
			}
			la2.setText("����" +sum+"�� �Դϴ�.");
		}
		
	}
	
	public static void main(String[] args) {
		new Ex11_05_InnerClass();
	}
}
