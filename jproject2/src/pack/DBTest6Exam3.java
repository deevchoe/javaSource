package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DBTest6Exam3 extends JFrame implements ActionListener {
	JTextField code = new JTextField("", 10);
	JTextField name = new JTextField("", 10);
	int num;
	String name2;

	JButton btnLogin = new JButton("로그인");

	JTextArea txtResult = new JTextArea();

	String sql = "";

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public DBTest6Exam3() {
		layInit();
		accDB();

		setBounds(200, 200, 700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void layInit() {
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("직원번호 : "));
		panel1.add(code);
		panel1.add(new JLabel("이름 : "));
		panel1.add(name);
		add("North", panel1);

		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtResult);
		add("Center", pane);

		btnLogin.addActionListener(this);
		panel1.add(btnLogin);
	}

	// 드라이버 로딩
	private void accDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			connectDB();
		} catch (Exception e) {
			System.out.println("accDB err : " + e); // 연결에 실패할 수 있으니 오류를 뿌려준다.
		}
	}

	// DB랑 연결하기
	private void connectDB() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "9112");
		} catch (Exception e) {
			System.out.println("processDB err : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == btnLogin) {
				accDB();
				if (code.getText().equals("")) {
					txtResult.setText("코드를 입력하세요");
					return;
				}
				try {
					num = Integer.parseInt(code.getText());
				} catch (Exception e2) {
					txtResult.setText("정수로 입력하세요");
					return;
				}
				// 품명
				if (name.getText().equals("")) {
					txtResult.setText("이름을 입력하세요");
					return;
				}
				try {
					name2 = name.getText();
				} catch (Exception e2) {
					return;
				}

				sql = "select * from jikwon";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setString(2, name2);
				rs = pstmt.executeQuery();
				txtResult.setText("사번 \t 직원명 \t 연봉 \t 직급 \t 평점 \n");

				while (rs.next()) {
					txtResult.append(rs.getInt("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t" + rs.getInt("jikwon_pay")
									+ "\t" + rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_rating") + "\n");
				}
				
				
				
				sql = "SELECT jikwon_jik 직급, AVG(jikwon_pay) 급여평균 FROM jikwon\r\n"
						+ "GROUP BY jikwon_jik";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				System.out.println();
				while(rs.next()) {
					txtResult.append(rs.getString("직급") + " : " +rs.getInt("급여평균") + "\t");
				}

			}
		} catch (Exception e2) {
			System.out.println("action arr : " + e2);
		} 
//		finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e3) {
//			}
//		}

	}

	public static void main(String[] args) {
		new DBTest6Exam3();
	}
}
