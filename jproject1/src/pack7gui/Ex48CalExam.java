package pack7gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48CalExam extends JFrame implements ActionListener {
	JButton btnCal, btnRe, btnEnd;
	JTextField num1, num2;
	int sum = 0;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton rAdd, rSub, rDiv, rMul;
	JLabel lblResult;
	JMenuItem mnuMes, mnuOk, mnuInput;

	public Ex48CalExam() {
		super("계산기");

		layoutInit();

		setBounds(200, 200, 300, 300);
		setVisible(true);

		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));

		// 1행
		JLabel lbl1 = new JLabel("숫자 1 : ");
		num1 = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(num1);
		add(panel1);

		// 2행
		JLabel lbl2 = new JLabel("숫자 2 : ");
		num2 = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(num2);
		add(panel2);

		// 3행
		rAdd = new JRadioButton(" + ", true);
		rSub = new JRadioButton(" - ", false);
		rDiv = new JRadioButton(" / ", false);
		rMul = new JRadioButton(" * ", false);
		buttonGroup.add(rAdd);
		buttonGroup.add(rSub);
		buttonGroup.add(rDiv);
		buttonGroup.add(rMul);
		JPanel panel3 = new JPanel();
		panel3.add(rAdd);
		panel3.add(rSub);
		panel3.add(rDiv);
		panel3.add(rMul);
		add(panel3);

		// 4행
		lblResult = new JLabel("결과 : " + JLabel.CENTER);
		add(lblResult);
		num1.requestFocus();
		
		// 5행
		btnCal = new JButton("계산");
		btnRe = new JButton("초기화");
		btnEnd = new JButton("종료");
		btnCal.addActionListener(this);
		btnRe.addActionListener(this);
		btnEnd.addActionListener(this);
		
		JPanel panel4 = new JPanel();
		panel4.add(btnCal);
		panel4.add(btnRe);
		panel4.add(btnEnd);
		add(panel4);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCal) {
			int n1 = 0, n2 = 0;
			if(n1 >= 0 && n2 >= 0) {
				// System.out.println(rAdd.isSelected() + " " + rSub.isSelected());
				if (rAdd.isSelected()) {
					n1 = Integer.parseInt(num1.getText());
					n2 = Integer.parseInt(num2.getText());
					int sum = n1 + n2;
					String message = "덧셈 결과는 " + sum;
					lblResult.setText(message);
				} else if (rSub.isSelected()) {
					n1 = Integer.parseInt(num1.getText());
					n2 = Integer.parseInt(num2.getText());
					int sub = n1 - n2;
					String message = "뺄셈 결과는 " + sub;
					lblResult.setText(message);
				} else if (rDiv.isSelected()) {
					double nu1 = Integer.parseInt(num1.getText());
					double nu2 = Integer.parseInt(num2.getText());
					double div = nu1 / nu2;
					String message = "나눗셈 결과는 " + div;
					lblResult.setText(message);
				} else if (rMul.isSelected()) {
					n1 = Integer.parseInt(num1.getText());
					n2 = Integer.parseInt(num2.getText());
					int mul = n1 * n2;
					String message = "곱셈 결과는 " + mul;
					lblResult.setText(message);
				}
			}
			}


		if (e.getSource() == btnRe) {
			num1.setText("");
			num2.setText("");
			rAdd.setSelected(true);
		}
		
		if(e.getSource() == btnEnd) { 
			int result = JOptionPane.showConfirmDialog(this, 
					"정말 종료하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
			switch(result) {
			case JOptionPane.YES_OPTION:
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex48CalExam();
	}

}
