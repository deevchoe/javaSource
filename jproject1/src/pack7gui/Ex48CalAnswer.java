package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48CalAnswer extends JFrame implements ActionListener {
	private JTextField txt1, txt2;
	int num1, num2;
	private ButtonGroup rbGroup = new ButtonGroup();
	private JRadioButton rbA, rbS, rbM, rbD;
	private JLabel lblResult;
	private JButton btnCalc, btnReset, btnEnd;
	
	public Ex48CalAnswer() {
		super("미니 계산기");
		
		calcLayout();

		setBounds(200, 200, 300, 300);
		setVisible(true);
	}
	
	private void calcLayout() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("숫자 1 : ");
		txt1 = new JTextField("",20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txt1);
		add(panel1);
		
		// 2행
		JLabel lbl2 = new JLabel("숫자 2 : ");
		txt2 = new JTextField("",20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txt2);
		add(panel2);
		
		// 3행
		JLabel lbl3 = new JLabel("연산 방법 : ");
		rbA = new JRadioButton("+",true);
		rbS = new JRadioButton("-",false);
		rbM = new JRadioButton("*",false);
		rbD = new JRadioButton("/",false);
		rbGroup.add(rbA);
		rbGroup.add(rbS);
		rbGroup.add(rbM);
		rbGroup.add(rbD);
		
		JPanel panel3 = new JPanel();
		panel3.add(rbA);
		panel3.add(rbS);
		panel3.add(rbM);
		panel3.add(rbD);
		add(panel3);
		
		// 4행
		lblResult = new JLabel("결과 : ", JLabel.CENTER);
		add(lblResult);
		
		// 5행
		btnCalc = new JButton("계산");
		btnReset = new JButton("초기화");
		btnEnd = new JButton("종료");
		btnCalc.addActionListener(this);
		btnReset.addActionListener(this);
		btnEnd.addActionListener(this);
		
		JPanel panel4 = new JPanel();
		panel4.add(btnCalc);
		panel4.add(btnReset);
		panel4.add(btnEnd);
		add(panel4);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCalc) {
			// 숫자1 오류 검사
			if(txt1.getText().equals("")) {
				lblResult.setText("숫자1을 입력하세요");
				txt1.requestFocus();
				return;
			}
			try {
				num1 = Integer.parseInt(txt1.getText());	// 숫자로 치환해서 변수 num1에 넣어줌
			} catch (Exception e2) {
				lblResult.setText("정수로 입력하세요");
				txt1.requestFocus();
				return;
			}
			
			// 숫자2 오류 검사
			if(txt2.getText().equals("")) {
				lblResult.setText("숫자2을 입력하세요");
				txt2.requestFocus();
				return;
			}
			try {
				num2 = Integer.parseInt(txt2.getText());	// 숫자로 치환해서 변수 num1에 넣어줌
			} catch (Exception e2) {
				lblResult.setText("정수로 입력하세요");
				txt2.requestFocus();
				return;
			}
			
			// 계산
			if(rbA.isSelected()) lblResult.setText("결과 : " + (num1 + num2));
			else if(rbS.isSelected()) lblResult.setText("결과 : " + (num1 - num2));
			else if(rbM.isSelected()) lblResult.setText("결과 : " + (num1 * num2));
			else {
				if(num1 == 0) {
					lblResult.setText("0은 나눌 수 없습니다.");
					txt1.setText("");
					txt1.requestFocus();
				}
				else if(num2 == 0) {
					lblResult.setText("0으로 나눌 수 없습니다.");
					txt2.setText("");
					txt2.requestFocus();
				}else lblResult.setText("결과 : " + (double)num1 / (double)num2);
			}
		}else if(e.getSource() == btnReset) {
			txt1.setText("");
			txt2.setText("");
			rbA.setSelected(true);
			txt1.requestFocus();
			lblResult.setText("결과 : ");
		}else {
			int result = JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?", "경고", JOptionPane.YES_NO_OPTION);
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
		new Ex48CalAnswer();
	}

}
