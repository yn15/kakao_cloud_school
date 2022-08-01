package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import book.vo.Book;

public class BookDAO {
	DataSource ds;
	
	public BookDAO() throws Exception{
		Context init = new InitialContext();
		ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQLDB");
	}

	public ArrayList<Book> select(String keyword) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "SELECT bisbn, btitle, bauthor, bprice, bimgurl FROM book WHERE btitle LIKE ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyword + "%");
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Book> list = new ArrayList<Book>();
		
		while(rs.next()) {
			Book book = new Book();
			book.setBisbn(rs.getString("bisbn"));
			book.setBtitle(rs.getString("btitle"));
			book.setBauthor(rs.getString("bauthor"));
			book.setBprice(rs.getString("bprice"));
			book.setBimgurl(rs.getString("bimgurl"));
			list.add(book);
		}
		
		pstmt.close();
		rs.close();
		con.close();
		
		return list;
	}

	public int delete(String bisbn) throws Exception{
		Connection con = ds.getConnection();
		System.out.println("연결성공");
		
		String sql = "DELETE FROM book WHERE bisbn = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bisbn);
		
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rs;
	}
}
