package pack7gui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex51ScoreExam extends JFrame implements ActionListener{
	private JTextField name, kor, eng, math;
	int num1, num2, num3, tot;
	double avg;
	String grade;
	
	private JLabel lblResult = new JLabel();
	private JLabel lblphoto = new JLabel();
	
	private JButton btnCheck, btnReset, btnFin;
	
//	ImageIcon ic = new ImageIcon("D:\\\\Study\\\\Academy\\\\Acorn\\\\jsource\\\\jproject1\\\\src\\\\pack7gui\\\\pack1.jpg");
//	Image img = ic.getImage();

	public Ex51ScoreExam() {
		super("성적 출력");
		
		scoreLayout();
		
		setBounds(200, 200, 600, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
//	@Override
//	public void paint(Graphics g) {
//		image = Toolkit.getDefaultToolkit().getImage("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack1.jpg");
//	}
	
	
	private void scoreLayout() {
		setLayout(new GridLayout(6, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("이름 : ");
		name = new JTextField("", 10);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(name);
		add(panel1);
		
		// 2행
		JLabel lbl2 = new JLabel("국어 : ");
		kor = new JTextField("", 10);
		JLabel lbl3 = new JLabel("영어 : ");
		eng = new JTextField("", 10);
		JLabel lbl4 = new JLabel("수학 : ");
		math = new JTextField("", 10);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(kor);
		panel2.add(lbl3);
		panel2.add(eng);
		panel2.add(lbl4);
		panel2.add(math);
		add(panel2);
		
		// 3행
		JPanel panel3 = new JPanel();
		//lblResult = new JLabel("총점 : ");
		panel3.add(lblResult);
		add(panel3);
		
		
		// 4행
		btnCheck = new JButton("확인");
		btnReset = new JButton("초기화");
		btnCheck.addActionListener(this);
		btnReset.addActionListener(this);
		
		JPanel panel4 = new JPanel();
		panel4.add(btnCheck);
		panel4.add(btnReset);
		add(panel4);
		
		// 5행
		JPanel panel5 = new JPanel();
		panel5.add(lblphoto);
		add(panel5);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCheck) {
			//System.out.println("check");
			if(name.getText().equals("")) {
				lblResult.setText("이름을 입력해주세요");
				name.requestFocus();
				return;
			}
			
			// 국어 점수 오류 검사
			if(kor.getText().equals("")) {
				lblResult.setText("점수를 입력하세요");
				kor.requestFocus();
				return;
			}
			try {
				num1 = Integer.parseInt(kor.getText());
			} catch (Exception e2) {
				lblResult.setText("정수로 입력하세요");
				kor.requestFocus();
				return;
			}
			// 영어 점수 오류 검사
			if(eng.getText().equals("")) {
				lblResult.setText("영어 점수를 입력하세요");
				eng.requestFocus();
				return;
			}
			try {
				num2 = Integer.parseInt(eng.getText());
			} catch (Exception e2) {
				lblResult.setText("정수로 입력하세요");
				eng.requestFocus();
				return;
			}
			// 수학 점수 오류 검사
			if(math.getText().equals("")) {
				lblResult.setText("수학 점수를 입력하세요");
				math.requestFocus();
				return;
			}
			try {
				num3 = Integer.parseInt(eng.getText());
			} catch (Exception e2) {
				lblResult.setText("정수로 입력하세요");
				math.requestFocus();
				return;
			}
			
			// 계산
			int tot = num1 + num2 + num3;
			double avg = tot / 3;
			
			int selImage = 0;
			
			if(avg >= 90) {
				grade = "A";
				lblResult.setText("\t총점 : " + tot + "\t평균 : " + avg + "평가 : " + grade);
				selImage = 1;
			}else if (avg >= 80) {
				grade = "B";
				lblResult.setText("\t총점 : " + tot + "\t평균 : " + avg + "평가 : " + grade);
				selImage = 1;
			} else if (avg >= 70) {
				grade = "C";
				lblResult.setText("\t총점 : " + tot + "\t평균 : " + avg + "평가 : " + grade);
				selImage = 2;
			} else if (avg >= 60) {
				grade = "D";
				lblResult.setText("\t총점 : " + tot + "\t평균 : " + avg + "평가 : " + grade);
				selImage = 2;
			} else {
				grade = "F";
				lblResult.setText("\t총점 : " + tot + "\t평균 : " + avg + "평가 : " + grade);
				selImage = 2;
			}
			
			switch (selImage) {
			case 1:
				lblphoto.setIcon(new ImageIcon("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack2.jpg"));
				break;
			
			case 2:
				lblphoto.setIcon(new ImageIcon("D:\\Study\\Academy\\Acorn\\jsource\\jproject1\\src\\pack7gui\\pack1.jpg"));
				break;
			}
		} else if (e.getSource() == btnReset) {
			name.setText("");
			kor.setText("");
			eng.setText("");
			math.setText("");
			
			lblphoto.setIcon(null);
		}
		
	}
	
	public static void main(String[] args) {
		new Ex51ScoreExam();
	}
}
