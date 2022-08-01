package book.service;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

import book.dao.BookDAO;
import book.vo.Book;

public class BookService {
	
	public ArrayList<Book> searchByKeyword(String keyword){
		try {
			BookDAO dao = new BookDAO();
			ArrayList<Book> list = dao.select(keyword);
			return list;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
	}

	public int deleteByKeyword(String bisbn) {
		try {
			BookDAO dao = new BookDAO();
			int row = dao.delete(bisbn);
			return row;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}
}
