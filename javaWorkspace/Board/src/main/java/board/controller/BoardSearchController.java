package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardService;
import board.vo.Board;
import user.vo.User;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/boardsearch")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		User user = (User) session.getAttribute("user");
		request.setCharacterEncoding("UTF-8");
		String keyword = request.getParameter("keyword");
		
		BoardService service = new BoardService();
		ArrayList<Board> list = service.boardsearch(keyword);

		if(list != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
			request.setAttribute("list", list);
			request.setAttribute("user", user);
			rd.forward(request, response);
		}else {
			
		}
	}

}
