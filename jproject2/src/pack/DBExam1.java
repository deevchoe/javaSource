package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBExam1 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public DBExam1() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//System.out.println("로딩성공");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "9112");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("부서 번호를 입력 하세요");
			int buser = scanner.nextInt();
			stmt = conn.createStatement();
			
			String sql = "SELECT jikwon_no 사번, jikwon_name 이름, jikwon_jik 직급, jikwon_pay 연봉 "
					+ "FROM jikwon INNER JOIN buser ON jikwon.buser_num=buser.buser_no"
					+ " where buser_num = " + buser;
			
			rs = stmt.executeQuery(sql);
			
			int cnt = 0;
			while(rs.next()) {
				String sabun = rs.getString(1);
				String name = rs.getString(2);
				String jik = rs.getString(3);
			//	buser = rs.getInt(3);
				int pay = rs.getInt(4);
				System.out.println(sabun + " " + name + " " + buser + " " + jik + " " + pay);
				cnt ++;
				}
			
			System.out.println("건수 : " + cnt);

		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		}finally {
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
		new DBExam1();
	}

}
