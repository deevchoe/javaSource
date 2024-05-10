package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Scanner;

public class Test15 {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Test15() {	
		try {
			Class.forName("org.mariadb.jdbc.Driver");
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
			System.out.print("부서명을 입력 하세요");
			String buser = scanner.next();
			System.out.println("사번\t이름\t직급\t성별");
			String sql = "SELECT jikwon_no 사번, jikwon_name 이름, jikwon_jik 직급, jikwon_gen 성별\r\n"
					+ "FROM jikwon\r\n"
					+ "INNER JOIN buser ON jikwon.buser_num = buser.buser_no\r\n"
					+ "WHERE buser_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buser);
			
		
			//pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String 사번 = rs.getString(1);
				String 이름 = rs.getString(2);
				String 직급 = rs.getString(3);
				String 성별 = rs.getString(4);
				
				System.out.println(사번 + "\t" + 이름 + "\t" + 직급 + "\t" + 성별);

				}
			
			sql = "SELECT jikwon_gen 성별, count(jikwon_gen) 인원수, FLOOR(AVG(jikwon_pay)) 급여평균 FROM jikwon\r\n"
					+ "INNER JOIN buser ON jikwon.buser_num = buser.buser_no\r\n"
					+ "WHERE buser_name=?\r\n"
					+ "GROUP BY jikwon_gen";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buser);
			rs = pstmt.executeQuery();
			
			System.out.println("\n성별\t인원수\t연봉평균");
			
			while(rs.next()) {
				String 성별 = rs.getString(1);
				Integer 인원수 = rs.getInt(2);
				Integer 급여평균 = rs.getInt(3);
				System.out.println(성별 + "\t" + 인원수 + "\t" + 급여평균);
			}

		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	public static void main(String[] args) {
		new Test15();
	}

}