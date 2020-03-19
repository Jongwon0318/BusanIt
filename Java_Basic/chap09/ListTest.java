package chap09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListTest extends JFrame implements ActionListener, ItemListener{
	private JTextField tf;
	private JTextArea ta;
	private List lst;
	private JCheckBox cb;

	public ListTest() {
		super("ListTest01");
		setLayout(new BorderLayout()); //��������(�⺻���̾ƿ�)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		p1.setLayout(new FlowLayout()); //��������(�⺻���̾ƿ�)
		
		tf=new JTextField(15);
		
		JButton btn=new JButton("�߰�");
		
		cb=new JCheckBox("���߼���");
		
		p1.add(tf); p1.add(btn); p1.add(cb);
		
		p2.setLayout(new GridLayout(1,2));
		
		lst=new List();
		ta=new JTextArea();
		
		p2.add(lst); p2.add(ta);
		
		p1.setBackground(Color.DARK_GRAY);
		
		add(BorderLayout.NORTH,p1);
		add(BorderLayout.CENTER,p2);
		
		btn.addActionListener(this);
		tf.addActionListener(this);
		lst.addItemListener(this);
		cb.addItemListener(this);
		
		
		setSize(400, 400);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(tf.getText().isEmpty()) return;
		lst.add(tf.getText());
		tf.setText("");
//		if(tf.getText().length()==0) {
//			
//		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//���� list or checkbox
		Object obj=e.getSource();
		if(obj==lst) { //����Ʈ
			//����, ���� ����
			ta.setText("");
			if(lst.isMultipleMode()) { //����Ʈ���߸��
				String[] arr=lst.getSelectedItems();
				for(int i=0; i<arr.length; i++) {
					ta.append(arr[i]+"\n");
				}
			}else { //����Ʈ���ϸ��
				ta.setText(lst.getSelectedItem());
			}
		}else if(obj==cb) { //üũ�ڽ�
			//üũ ���� or ����
			if(cb.isSelected()) { //����
				lst.setMultipleMode(true); //���߼���
			}else {
				lst.setMultipleMode(false); //���ϼ���
			}
		}
		
//		
//		if(cb.isSelected()==false) {
//			lst.setMultipleMode(false);
//			ta.setText(lst.getSelectedItem());
//		}else {
////			if(ta.getText().isEmpty()==false) ta.setText("");
//			lst.setMultipleMode(true);
//			String[] arr=lst.getSelectedItems();
//			for(int i=0; i<arr.length; i++) {
//				ta.append(arr[i]+"\n");
//			}
//		}
	}
	
	public static void main(String[] args) {
		new ListTest();
	}


}
