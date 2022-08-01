package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import user.vo.User;

public class UserDAO {
	DataSource ds;
	
	public UserDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public User select(User user) throws Exception{
		
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "SELECT * FROM users WHERE userID = ? AND userPW = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserID());
		pstmt.setString(2, user.getUserPW());
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			user.setUserName(rs.getString("userName"));
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return user;
	}

	public int insert(User user) throws Exception{
		
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "INSERT INTO users VALUES(?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserID());
		pstmt.setString(2, user.getUserPW());
		pstmt.setString(3, user.getUserName());
		int result = pstmt.executeUpdate();

		pstmt.close();
		con.close();
		
		return result;
	}
	
	
	
	
}
