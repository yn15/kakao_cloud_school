package comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comment.dao.CommentDAO;
import comment.service.CommentService;
import comment.vo.Comment;
import user.vo.User;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		
		String content = request.getParameter("content");
		String bNumber = request.getParameter("bNumber");
		String bHits = request.getParameter("bHits");
		
		Comment comment = new Comment();
		comment.setbNumber(bNumber);
		comment.setContent(content);
		comment.setCuserID(user.getUserID());
		
		CommentService service = new CommentService();
		
		int result = service.writeComment(comment);
		
		if(result != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("/boarddetail");
			request.setAttribute("bNumber", bNumber);
			request.setAttribute("bHits", bHits);
			rd.forward(request, response);
		}
	}

}
