package lecture0722.SimpleBookSearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lecture0722.SimpleBookSearch.vo.BookVO;
	
// DAO , 단일 Database Access만 해야함
public class BookDAO {
	
	CreateConnection createConnection;
	
	public BookDAO(CreateConnection createConnection) {
		this.createConnection = createConnection;
	}
	
	public ArrayList<BookVO> select(String keyword) throws ClassNotFoundException, SQLException{
		ArrayList<BookVO> list = null;
		
		Connection con = createConnection.newConnection();
			
		String sql = "SELECT bisbn, btitle, bauthor FROM book WHERE btitle like ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
			
		pstmt.setString(1, "%" + keyword + "%");
			
		ResultSet rs = pstmt.executeQuery();
			
		list = new ArrayList<BookVO>();
			
		while(rs.next()) {
			BookVO tmp = new BookVO();
			tmp.setBtitle(rs.getString("Btitle"));
			tmp.setBauthor(rs.getString("Bauthor"));
			tmp.setBisbn(rs.getString("Bisbn"));
			
			list.add(tmp);
		}
			
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}
	
	public int delete(String keyword) throws ClassNotFoundException, SQLException{
		ArrayList<BookVO> list = null;
		
		Connection con = createConnection.newConnection();
			
		String sql = "DELETE FROM book WHERE bisbn = ?";

		PreparedStatement pstmt = con.prepareStatement(sql);
			
		pstmt.setString(1, keyword);
			
		int rs = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		return rs;
	}
}
