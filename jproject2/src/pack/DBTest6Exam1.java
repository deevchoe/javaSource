package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// 문제 : https://cafe.daum.net/flowlife/HqLo/53
public class DBTest6Exam1 extends JFrame implements ActionListener{
	JTextField code = new JTextField("", 10);
	JTextField name = new JTextField("", 10);
	JTextField cnt = new JTextField("", 10);
	JTextField dan = new JTextField("", 10);

	
	//private JTextField code, name, cnt, dan;
	int num1, num2, num3;	// code, cnt, dan
	String name2;
	
	JButton btnA = new JButton("추가");
	
	JTextArea txtResult = new JTextArea();
	
	String sql = "";

	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DBTest6Exam1() {
		setTitle("상품 처리");
		
		layInit();
		accDB();
		
		setBounds(200, 200, 700, 400);
		setVisible(true);
		display();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnA) {
				
				accDB();
				//System.out.println("클릭");
				if(code.getText().equals("")) {
					txtResult.setText("코드를 입력하세요");
					return;
				}
				try {
					num1 = Integer.parseInt(code.getText());
				}catch (Exception e2) {
					txtResult.setText("정수로 입력하세요");
					return;
				}
				// 품명
				if(name.getText().equals("")) {
					txtResult.setText("품명 입력하세요");
					return;
				}
				try {
					name2 = name.getText();
				} catch (Exception e2) {
					return;
				}

				// 수량
				if(cnt.getText().equals("")) {
					txtResult.setText("수량을 입력하세요");
					return;
				}
				try {
					num2 = Integer.parseInt(cnt.getText());
				}catch (Exception e2) {
					txtResult.setText("정수로 입력하세요");
					return;
				}
				
				// 단가
				if(dan.getText().equals("")) {
					txtResult.setText("단가를 입력하세요");
					return;
				}
				try {
					num3 = Integer.parseInt(dan.getText());
				}catch (Exception e2) {
					txtResult.setText("정수로 입력하세요");
					return;
				}			
				
				txtResult.setText(null);

				sql = "insert into sangdata values(?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num1);
				pstmt.setString(2, name2);
				pstmt.setInt(3, num2);
				pstmt.setInt(4, num3);
				pstmt.executeUpdate();

				display();

			}

		
		} catch (Exception e2) {
			System.out.println("err : " + e);
		}
		
	}
	
	private void display() {
		try {
			sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			txtResult.setText("코드 \t 상품명 \t 수량 \t 단가 \t 금액 \n");
			
			DecimalFormat df = new DecimalFormat("#,##0");
			
			while(rs.next()) {
				txtResult.append(rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + 
						"\t" + rs.getString("dan") + "\t" + df.format(rs.getInt("su") * rs.getInt("dan")) + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		
	}
	
	private void accDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			processDB();
		} catch (Exception e) {
			System.out.println("accDB err : " + e); 	// 연결에 실패할 수 있으니 오류를 뿌려준다.
		}
	}	
	
	private void processDB() {
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "9112");
			
			//pstmt = conn.prepareStatement(sql);
			//display();
		} catch (Exception e) {
			System.out.println("processDB err : " + e);
		}
	}
	
	private void layInit() {
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("코드 : "));
		panel1.add(code);
		panel1.add(new JLabel("품명 : "));
		panel1.add(name);
		panel1.add(new JLabel("수량 : "));
		panel1.add(cnt);
		panel1.add(new JLabel("단가 : "));
		panel1.add(dan);
		//panel1.add(dan);
		add("North", panel1);

		
		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtResult);
		add(pane);

		
		
		btnA.addActionListener(this);
		panel1.add(btnA);
		
		//plus.addActionListener(this);		
		
		/*
		JPanel jPanel = new JPanel();
		jPanel.add(new JLabel("코드 : "));
		JLabel lbl = new JLabel("코드 : ");
		code = new JTextField("", 5);
		JLabel lbl2 = new JLabel("품명 : ");
		name = new JTextField("", 5);
		JLabel lbl3 = new JLabel("수량 : ");
		cnt = new JTextField("", 5);
		JLabel lbl4 = new JLabel("단가 : ");
		dan = new JTextField("", 5);
		btnA = new JButton("추가");
		
		jPanel.add(lbl);
		jPanel.add(code);
		jPanel.add(lbl2);
		//jPanel.add(name2);
		jPanel.add(lbl3);
		jPanel.add(cnt);
		jPanel.add(lbl4);
		jPanel.add(dan);
		jPanel.add(btnA);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.add(txtResult);
		add(jPanel2);
		
		add("North",jPanel);
		
		//accDB();
	
		
		btnA.addActionListener(this);
		*/
		
		
	}
	

	
	public static void main(String[] args) {
		new DBTest6Exam1();
	}

}
