package lecture0722.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {
	
	protected Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_URL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		Connection con = DriverManager.getConnection(jdbc_URL, "root", "1234");
		
		return con;
	}
	
	
	public void insert(User user) throws ClassNotFoundException, SQLException{
		// try ~ catch 사용하지않음
		
		Connection con = getConnection();
		
		String sql = "INSERT INTO users VALUES (?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		
		pstmt.executeUpdate();
		pstmt.close();
		con.close();
	}
	
	public User select(String id ) throws ClassNotFoundException, SQLException {
		
		Connection con = getConnection();
		
		String sql = "SELECT * FROM users WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		User user = new User();
		
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}
	
}
