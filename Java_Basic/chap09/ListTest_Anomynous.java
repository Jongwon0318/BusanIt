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

public class ListTest_Anomynous extends JFrame {

	private ListTest_Anomynous() {
		super("ListTest01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();

		JTextField tf = new JTextField(15);

		JButton btn = new JButton("추가");

		JCheckBox cb = new JCheckBox("다중선택");

		p1.add(tf);
		p1.add(btn);
		p1.add(cb);

		p2.setLayout(new GridLayout(1, 2));

		List lst = new List();
		JTextArea ta = new JTextArea();

		p2.add(lst);
		p2.add(ta);

		p1.setBackground(Color.DARK_GRAY);

		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER, p2);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf.getText().isEmpty())
					return;
				lst.add(tf.getText());
				tf.setText("");
			}
		});

		tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf.getText().isEmpty())
					return;
				lst.add(tf.getText());
				tf.setText("");
			}
		});

		lst.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (lst.isMultipleMode()) { // 다중
					ta.setText("");
					String[] tmp = lst.getSelectedItems();
					for (int i = 0; i < tmp.length; i++) {
						ta.append(tmp[i] + "\n");
					}
				} else { // 단일
					ta.setText(lst.getSelectedItem());
				}
			}
		});

		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (cb.isSelected()) { // 다중
					lst.setMultipleMode(true);
				} else { // 단일
					lst.setMultipleMode(false);
				}
			}
		});

		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListTest_Anomynous();
	}

}
