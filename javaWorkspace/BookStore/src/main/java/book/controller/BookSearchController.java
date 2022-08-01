package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.JsonArray;

import book.service.BookService;
import book.vo.Book;

/**
 * Servlet implementation class BookSearchController
 */
@WebServlet("/bsearch")
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		BookService service = new BookService();
		ArrayList<Book> list = service.searchByKeyword(keyword);
		
		if( list != null) {
			// list를 jsp에게 전달해서 결과를 클라이언트에게 전송
			// 1회성 데이터이기 때문에 request에 붙이는게 효율적
			// ServletContext나 session은 메모리 공간을 계속 잡고있는다.
			RequestDispatcher rd = request.getRequestDispatcher("/book/bookSearchResult.jsp");
			request.setAttribute("result", list);
			request.setAttribute("keyword", keyword);
			rd.forward(request, response);
		}else {
			// 오류페이지 출력 redirect
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
