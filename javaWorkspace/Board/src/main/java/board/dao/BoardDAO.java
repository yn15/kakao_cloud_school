package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.vo.Board;
import comment.vo.Comment;

public class BoardDAO {
	DataSource ds;
	
	public BoardDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}
	
	
	public ArrayList<Board> select() throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "SELECT * FROM board";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Board> list = new ArrayList<>();
		while(rs.next()) {
			Board board = new Board();
			board.setbContents(rs.getString("bContents"));
			board.setbDate(rs.getString("bDate"));
			board.setbHits(rs.getInt("bHits"));
			board.setbLikes(rs.getInt("bLikes"));
			board.setbNumber(rs.getString("bNumber"));
			board.setbTitle(rs.getString("bTitle"));
			board.setUserID(rs.getString("userID"));
			list.add(board);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}


	public Board selectByNumber(String bNumber) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		//String sql = "SELECT * FROM board where bNumber = ?";
		String sql = "SELECT * FROM board b LEFT JOIN comment c ON b.bNumber = c.bNumber WHERE b.bNumber=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bNumber);
		ResultSet rs = pstmt.executeQuery();
		
		Board board = new Board();
		
		ArrayList<Comment> list = new ArrayList<>();
			
		if(rs.next()) {
			board.setBcomments(rs.getString("bcomments"));
			board.setbContents(rs.getString("bContents"));
			board.setbDate(rs.getString("bDate"));
			board.setbHits(rs.getInt("bHits"));
			board.setbLikes(rs.getInt("bLikes"));
			board.setbNumber(rs.getString("bNumber"));
			board.setbTitle(rs.getString("bTitle"));
			board.setUserID(rs.getString("userID"));
			if(rs.getString("cuserID") != null) {
				Comment comment = new Comment();
				comment.setCuserID(rs.getString("cuserID"));
				comment.setContent(rs.getString("content"));
				comment.setcID(rs.getString("cID"));
				list.add(comment);
				while(rs.next()) {
					comment = new Comment();
					comment.setCuserID(rs.getString("cuserID"));
					comment.setContent(rs.getString("content"));
					comment.setcID(rs.getString("cID"));
					list.add(comment);
				}
			}
		}
		
		board.setList(list);
		rs.close();
		pstmt.close();
		con.close();
		
		return board;
	}


	public int insertBoard(Board board) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "INSERT INTO board(bTitle, bContents, userID) VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		pstmt.setString(1, board.getbTitle());
		pstmt.setString(2, board.getbContents());
		pstmt.setString(3, board.getUserID());
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return result;
	}


	public int UpdateHits(String bNumber, int bHits) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "UPDATE board SET bHits = ? WHERE bNumber = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		pstmt.setInt(1, bHits);
		pstmt.setString(2, bNumber);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return result;
	}


	public int UpdateLikes(String bNumber, int bLikes) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "UPDATE board SET bLikes = ? WHERE bNumber = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		
		pstmt.setInt(1, bLikes);
		pstmt.setString(2, bNumber);
		
		int result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return result;
	}


	public int deleteBoard(String bNumber)  throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "DELETE FROM comment WHERE bNumber = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, bNumber);
		
		int result = pstmt.executeUpdate();
		
		sql = "DELETE FROM board WHERE bNumber = ?";
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, bNumber);
		
		result = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return result;
	}

}
