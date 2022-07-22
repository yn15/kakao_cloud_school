package lecture0722.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// naver 쪽 개발자가 UserDAO를 이용하기 위해
public class NUserDAO extends UserDAO{

	@Override
	protected Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = DriverManager.getConnection(jdbc_URL, "root", "1234");
		
		return con;
	}
	
}
