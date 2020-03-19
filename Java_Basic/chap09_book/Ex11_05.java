package chap09_book;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex11_05  extends JFrame{
	int sum=0;
	JCheckBox cb1,cb2,cb3;
	JLabel la2;
	
	public Ex11_05(){
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
		
		setSize(250, 300);
		setVisible(true);
		
		cb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cb1=(JCheckBox) e.getSource();
				if(cb1.isSelected()==true) {
					sum+=100;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}else {
					sum-=100;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}
			}
		});
		
		cb2.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cb2=(JCheckBox) e.getSource();
				if(cb2.isSelected()==true) {
					sum+=500;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}else {
					sum-=500;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}
			}
		});
		
		cb3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				cb3=(JCheckBox) e.getSource();
				if(cb3.isSelected()==true) {
					sum+=20000;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}else {
					sum-=20000;
					la2.setText("����" +sum+"�� �Դϴ�.");
				}
			}
		});

	}
	
	public static void main(String[] args) {
		new Ex11_05();
	}
}
