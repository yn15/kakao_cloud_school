package board.controller;

import java.io.IOException;

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
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/boardwrite")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
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
		String bTitle = request.getParameter("bTitle");
		String bContents = request.getParameter("bContents");
		String userID = user.getUserID();
		
		Board board = new Board();
		board.setbTitle(bTitle);
		board.setbContents(bContents);
		board.setUserID(userID);
		
		BoardService service = new BoardService();
		int result = service.boardWrite(board);
		
		if( result != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/boardlist");
			rd.forward(request, response);
		}else {
			
		}
		
	}

}
