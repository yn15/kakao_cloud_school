package lecture0722.step4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserDAO {

	private SimpleConnectionMaker simpleConnectionMaker; // 이 Class에 종속되게 되버림
	
	public UserDAO() {
		this.simpleConnectionMaker = new SimpleConnectionMaker();
	}
	
	public void insert(User user) throws ClassNotFoundException, SQLException{
		// try ~ catch 사용하지않음
		
		Connection con = simpleConnectionMaker.makeNewConnection();
		
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
		
		Connection con = simpleConnectionMaker.makeNewConnection();
		
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
