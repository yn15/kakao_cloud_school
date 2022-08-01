package book.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.service.BookService;
import book.vo.Book;

/**
 * Servlet implementation class BookDeleteController
 */
@WebServlet("/bdelete")
public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bisbn = request.getParameter("bisbn");
		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		BookService service = new BookService();
		int row = service.deleteByKeyword(bisbn);
		
		keyword = URLEncoder.encode(keyword, "UTF-8");
		if( row != 0) {
			// list를 jsp에게 전달해서 결과를 클라이언트에게 전송
			// 1회성 데이터이기 때문에 request에 붙이는게 효율적
			// ServletContext나 session은 메모리 공간을 계속 잡고있는다.
			response.sendRedirect("/book/bsearch?keyword="+keyword);
			
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
