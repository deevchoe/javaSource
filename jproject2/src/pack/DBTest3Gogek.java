package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBTest3Gogek extends JFrame implements ActionListener{
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();		// select의 결과가 찍히는 용도로 사용함
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	
	public DBTest3Gogek() {
		setTitle("고객 자료");
		
		layInit();
		accDB();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} 
	
	private void layInit() {
		JPanel jPanel = new JPanel();
		jPanel.add(btnA);
		jPanel.add(btnM);
		jPanel.add(btnF);
		
		txtResult.setEditable(false); 		// Read Only  => view만 된다.
		JScrollPane pane = new JScrollPane(txtResult);
		
		add("Center", pane);
		add("North", jPanel);
		
		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);
		
	}
	
	private void accDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDB err : " + e); 	// 연결에 실패할 수 있으니 오류를 뿌려준다.
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// DB 연결은 필요 시 접속하고 작업이 끝나면 반드시 연결을 해제한다.
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "9112"); // 드라이브 매니저 객체를 이용해서 conn을 인스턴스 했다.
			
			stmt = conn.createStatement();
			
			String sql= "select gogek_no, gogek_name, gogek_jumin from gogek";		// 공통 sql문
			
			if(e.getSource() == btnA) {
				
			}else if(e.getSource() == btnM) {
				sql += " where gogek_jumin like '%-1%'";
				//sql += " where substr(gogek_jumin,8,1)=1";		// 주민번호 8번째 자리 숫자가 1이면		
			}else if(e.getSource() == btnF) {
				sql += " where gogek_jumin like '%-2%'";
			}
			
			txtResult.setText(null);		// 출력 영역을 먼저 깨끗하게 비워놓음
			
			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			
			while(rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t" +
						rs.getString("gogek_name") + "\t" +
						rs.getString("gogek_jumin") + "\n";
				
				txtResult.append(imsi);
				count++;
			}
			
			txtResult.append("인원수 : " + count);
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e);
		}finally {		// 에러가 나거나 말거나 반드시 수행
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DBTest3Gogek();
	}

}
