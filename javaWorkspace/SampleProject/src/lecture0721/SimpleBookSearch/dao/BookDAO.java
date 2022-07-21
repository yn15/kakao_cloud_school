package lecture0721.SimpleBookSearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lecture0721.SimpleBookSearch.vo.BookVO;

// DAO , 단일 Database Access만 해야함
public class BookDAO {
	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public ArrayList<BookVO> select(String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookVO> list = null;
		
		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
			con = DriverManager.getConnection(jdbcURL, "root", "1234");
			
			String sql = "SELECT bisbn, btitle, bauthor FROM book WHERE btitle like ?";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "%" + keyword + "%");
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BookVO>();
			
			while(rs.next()) {
				BookVO tmp = new BookVO();
				tmp.setBtitle(rs.getString("Btitle"));
				tmp.setBauthor(rs.getString("Bauthor"));
				tmp.setBisbn(rs.getString("Bisbn"));
				
				list.add(tmp);
			}
			
		} catch (Exception e2) {
			System.out.println(e2);
		}finally {
			try {
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public int delete(String keyword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		ArrayList<BookVO> list = null;
		
		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/bookstore?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
			con = DriverManager.getConnection(jdbcURL, "root", "1234");
			
			String sql = "DELETE FROM book WHERE bisbn = ?";

			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, keyword);
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e2) {
			System.out.println(e2);
		}finally {
			try {
				if( pstmt != null) pstmt.close();
				if( con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}
}
