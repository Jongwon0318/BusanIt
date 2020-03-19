package chap09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CheckboxTest_InnerClass extends JFrame{
	JCheckBox jc1, jc2;
	JTextArea ta;
	public CheckboxTest_InnerClass() {
		super("ChechboxTest");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p1 = new JPanel();
		ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		jc1 = new JCheckBox("바나나");
		jc2 = new JCheckBox("오렌지");
		p1.add(jc1);
		p1.add(jc2);
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER, jsp);
		
		ItemHandler ih=new ItemHandler();
		jc1.addItemListener(ih);
		jc2.addItemListener(ih);
			
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckboxTest_InnerClass();
	}
	
	class ItemHandler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			//JCheckBox cb=(JCheckBox)e.getItem();
			JCheckBox cb=(JCheckBox)e.getSource();
			if (cb.isSelected()==true) {
				ta.append(cb.getText()+"선택\n");
				ta.setBackground(Color.MAGENTA);
			}else {
				ta.append(cb.getText()+"선택해제\n");
				ta.setBackground(Color.WHITE);
			}
		}
	}
}
