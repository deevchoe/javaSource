package pack;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProcessDao {
	private static ProcessDao dao = new ProcessDao();
	
	public static ProcessDao  getInstance() {
		return dao;
	}
	
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public List<DataDto> selectDataAll() throws SQLException{
		SqlSession sqlSession = factory.openSession();	// 세션(웹에서 알고 있는 그 세션이 아닌 하나의 작업단위를 말한다) 열기
		List list = sqlSession.selectList("selectDataAll");
		sqlSession.close();
		return list;
	}
	
	public DataDto selectPart(String para) throws SQLException{
		SqlSession sqlSession = factory.openSession(); // 세션 열기
		DataDto dto = sqlSession.selectOne("selectDataById", para);
		sqlSession.close();
		return dto;
	}
	
	public void insData(DataDto dto) throws SQLException{ // insert,update,delete는 커밋이나 롤백이 있기 때문에 트랜잭션을 생각해야 한다. 커밋이나 롤백을 만나면 트랜잭션이 끝나는거에요
		SqlSession sqlSession = factory.openSession();		// transaction 수동 처리
		sqlSession.insert("insertData", dto);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void upData(DataDto dto) throws SQLException{	// void는 됐는지 안됐는지 클라이언트에게 알려주지 않음
		SqlSession sqlSession = factory.openSession(true); // transaction 자동 처리
		sqlSession.update("updateData", dto);
		sqlSession.close();
	}
	
	public boolean delData(int para) {
		boolean result = false;
		SqlSession sqlSession = factory.openSession();
		
		try {
			int cou = sqlSession.delete("deleteData", para);	// cou가 0이면 삭제 실패, 0보다 크면 삭제 성공
			if(cou > 0) result = true;
			
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("delData err : " + e);
			sqlSession.rollback();  // 에러났으면 롤백해줘!!!
		} finally {
			if(sqlSession != null) sqlSession.close();
		}
		
		return result;
	}
}