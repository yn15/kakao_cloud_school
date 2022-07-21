package lecture0721;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainDelete {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC Driver Loading
			// MySQL 8.0부터는 아래의 class를 이용
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
			
			// 2. 데이터베이스 연결
			String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
			con = DriverManager.getConnection(jdbcURL, "root", "1234");
			System.out.println("데이터베이스 연결 성공!");
			
			con.setAutoCommit(false); // 트랜잭션 시작
			
			// PreparedStatment는 IN Parameter를 사용 할 수 있음
			String sql = "DELETE FROM buytbl WHERE userID=?";
			
			// 3. Statement 생성
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "BBK");
			
			// 4. 실행
			int result = pstmt.executeUpdate();
			
			// 5. 결과처리
			System.out.println("총 " + result + "행이 삭제되었습니다.");
			
			con.rollback(); // 트랜잭션이 종료
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			System.out.println(e2);
		} finally {
			// 6. 사용한 자원을 해제
			try {
				if ( pstmt != null ) pstmt.close();
				if ( con != null ) con.close();
			} catch (SQLException e) {
			}
		}
		
	}
}
