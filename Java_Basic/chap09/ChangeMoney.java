package chap09;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeMoney extends JFrame {

	private int[] unit = { 50000, 10000, 1000, 500, 100, 50, 10, 1 };
	private String[] text = { "오만원", "만원", "천원", "오백원", "백원", "오십원", "십원", "일원" };
	private JTextField[] tf = new JTextField[8];
	private JCheckBox[] cb = new JCheckBox[7];

	public ChangeMoney() {
		super("ChangeMoney");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.orange);

		// 금액
		JLabel la = new JLabel("금액");
		la.setHorizontalAlignment(JLabel.RIGHT);
		la.setSize(50, 20);
		la.setLocation(20, 20);
		add(la);

		// 입력창
		JTextField won = new JTextField(30);
		won.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽정렬
		won.setSize(100, 20);
		won.setLocation(100, 20);
		add(won);

		// 계산버튼
		JButton btn = new JButton("계산");
		btn.setSize(70, 20);
		btn.setLocation(210, 20);
		add(btn);
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int money = Integer.parseInt(won.getText());
				for (int i = 0; i < unit.length - 1; i++) {
					if (!cb[i].isSelected()) {
						tf[i].setText("0");
						continue;
					}
					tf[i].setText(String.valueOf(money / unit[i]));
					money %=unit[i];
				}
				tf[text.length - 1].setText(String.valueOf(money));

//				for(int i=0; i<cb.length; i++) {
//					if(cb[i].isSelected()==true) {
//						for(int j=0; i<unit.length; i++) {
//							tf[j].setText(String.valueOf(money/unit[j]));
//							money=money%unit[j];
//						}
//					}else {
//						tf[i].setText("0");
//					}
//				}

			}
		});

		// 액수별 for
		for (int i = 0; i < text.length; i++) {
			la = new JLabel(text[i]);
			la.setHorizontalAlignment(JLabel.RIGHT);
			la.setSize(50, 20);
			la.setLocation(50, 50 + i * 20);
			add(la);

			// JTextField
			tf[i] = new JTextField();
			tf[i].setHorizontalAlignment(JTextField.CENTER);
			tf[i].setEnabled(false);
			tf[i].setSize(70, 20);
			tf[i].setLocation(120, 50 + i * 20);
			add(tf[i]);

			// checkbox
			if (i == text.length - 1)
				break;
			cb[i] = new JCheckBox();
			cb[i].setSelected(true);
			cb[i].setBackground(Color.orange);
			cb[i].setSize(30, 20);
			cb[i].setLocation(200, 50 + i * 20);
			add(cb[i]);
		}

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeMoney();
	}

}