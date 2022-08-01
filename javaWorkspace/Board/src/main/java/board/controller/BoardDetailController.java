package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;
import board.vo.Board;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/boarddetail")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
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
		String bNumber = request.getParameter("bNumber");
		int bHits = Integer.parseInt(request.getParameter("bHits"));
		
		BoardService service = new BoardService();
		Board board = service.board(bNumber);
		
		board.setbHits(bHits);
		
		int result = service.hits(bNumber, bHits);
		
		if(board != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
			request.setAttribute("board", board); 
			rd.forward(request, response);
		}else {
			
		}
		
		
	}

}
