package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardService;

/**
 * Servlet implementation class BoardLikeController
 */
@WebServlet("/boardlike")
public class BoardLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardLikeController() {
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
		int bLikes = Integer.parseInt(request.getParameter("bLikes"));
		String bNumber = request.getParameter("bNumber");
		String bHits  = request.getParameter("bHits");
		BoardService service = new BoardService();
		
		int result = service.likes(bNumber, bLikes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/boarddetail");
		request.setAttribute("bNumber", bNumber);
		request.setAttribute("bHits", bHits);
		rd.forward(request, response);
		
		
	}

}
