package lecture0722.SimpleBookSearch.service;

import java.sql.SQLException;
import java.util.ArrayList;

import lecture0722.SimpleBookSearch.dao.BookDAO;
import lecture0722.SimpleBookSearch.vo.BookVO;
import lecture0722.SimpleBookSearch.dao.CreateConnection;

// Service
public class BookService {
	private BookDAO dao;
	
	public BookService(CreateConnection createConnection) {
		this.dao = new BookDAO(createConnection);
	}
	
	public ArrayList<BookVO> bookSearchByKeyword(String keyword) throws ClassNotFoundException, SQLException{
		// 키워드를 이용해서 찾는 로직 처리
		// for, if 로직처리가 일반적으로 나오는데
		// Database 처리를 해야함
		ArrayList<BookVO> result = dao.select(keyword);
		
		return result;
	}
	
	public int bookDeleteByISSBN(String bisbn) throws ClassNotFoundException, SQLException {
		// 책 고유번호를 받아서 해당 책을 삭제하는 로직 처리
		int count = dao.delete(bisbn);
		return count;
	}
}
