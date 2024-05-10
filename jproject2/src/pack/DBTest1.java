package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// MariaDB(원격 DB 서버) 연동 프로그래밍
public class DBTest1 {
	private Connection conn;	// 원격DB..데이터베이스와 연결한다. conn은 하나만 있을 수 있다.
	private Statement stmt;	// sql문을 실행할 수 있음 : Statement, 여러개 가능, 커넥션 객체를 이용함
	private ResultSet rs;	// 쿼리의 결과를 받아옴 : ResultSet, 여러개 가능
	
	public DBTest1() {
		// 1. Driver file loading : mariadb 연결하는법
		// 외부에 있는거니까 빌드 패쓰해야됨
		try {
			Class.forName("org.mariadb.jdbc.Driver");	// 이걸 써서 연결해줘			
		}catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		
		// 2. DB Server와 연결 : mariaDB에 있는 자료와 연결하는 법
		try {
			//String url="jdbc:mysql://서버명:3306/DB명";
			//conn=DriverManager.getConnection(url,username,password);
			String url="jdbc:mariadb://localhost:3306/test";
			// mariadb :
			// mysql : 
			conn = DriverManager.getConnection(url, "root", "9112");	// connection 객체가 만들어졌다!
			// 실무에선 root로 하면 안됨
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		
		// 3. 연결된 DB Server에 SQL 실행 : 만들어 놓은 쿼리 갖고오기(select * from sangdata)
		try {
			// sangdata 테이블 자료 읽기
			stmt = conn.createStatement();	// conn에 stmt를 인스턴스함
			
			//rs = stmt.executeQuery("select * from sangdata");		-> 칼람명 *처리
			rs = stmt.executeQuery("select code, sang, su, dan from sangdata");
			//rs.next();	// cursor(레코드 포인터)를 이동시켜줌. 이클립스는 한행씩 읽음	// 첫번째 레코드에 있는거 찍어봐
			//rs.next();	// 두번째 레코드에 있는거 찍어봐
			
			//System.out.println(rs.next());	// true : 그 다음 자료가 있다라는 의미
			//System.out.println(rs.getString("sang"));
			while(rs.next()) {		// 자료가 있는 동안 반복한다 true
				String code = rs.getString("code");		// 타입을 맞춰줘야 한다
				String sangpum = rs.getString("sang");
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			}
			
			System.out.println("-------");
			rs.close(); 	// ResultSet을 닫고, 아래에서 다시 열기
			
			rs = stmt.executeQuery("select code as 코드, sang as 상품명, su, dan from sangdata");
			while(rs.next()) {
			//	String code = rs.getString("code");		// 별칭이 달라서 에러남
				String code = rs.getString("코드");
				String sangpum = rs.getString(2);	// 칼람은 순서가 있다. 1부터 부여된다.
				int su = rs.getInt(3);
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			}
			
			//String sql = "select count(*) as 건수 from sangdata";
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			//System.out.println("건수 : " + rs.getString("건수"));
			//System.out.println("건수 : " + rs.getString("count(*)"));
			System.out.println("건수 : " + rs.getString(1));
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {		// 에러가 나거나 말거나 반드시 수행
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
		new DBTest1();
	}
}
