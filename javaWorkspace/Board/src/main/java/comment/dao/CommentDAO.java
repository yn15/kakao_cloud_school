package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import comment.vo.Comment;

public class CommentDAO {
	DataSource ds;
	
	public CommentDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	public int insert(Comment comment) throws Exception{
		
		Connection con = ds.getConnection();
		
		String sql = "INSERT INTO comment(content, cuserID, bNumber) VALUES (?, ?, ?)";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, comment.getContent());
		pstmt.setString(2, comment.getCuserID());
		pstmt.setString(3, comment.getbNumber());
		
		int result = pstmt.executeUpdate();
		
		
		pstmt.close();
		con.close();
		return result;
	}

	public int delete(String cID) throws Exception{
		Connection con = ds.getConnection();
		System.out.println(cID);
		String sql = "DELETE FROM comment WHERE cID = ?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, cID);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return result;
	}
	
	
	
}
