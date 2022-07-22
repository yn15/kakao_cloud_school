package lecture0722.SimpleBookSearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NBookDAO implements CreateConnection{
	@Override
	public Connection newConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
		Connection con = DriverManager.getConnection(jdbcURL, "root", "1234");
		return con;
	}
}
