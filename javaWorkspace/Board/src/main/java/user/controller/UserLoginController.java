package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		
		User user = new User();
		user.setUserID(userID);
		user.setUserPW(userPW);
		
		UserService service = new UserService();
		
		user = service.signin(user);
		if( user.getUserName() != null) {
			System.out.println(user.getUserName());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("/boardlist");
			rd.forward(request, response);
			
//			RequestDispatcher rd = request.getRequestDispatcher("/user/boardList.jsp");
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
//			rd.forward(request, response);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다.'); location.href='"+"/board/user/login.html"+"';</script>"); 
			//response.sendRedirect("/board/user/login.html");
			writer.close();
			
		}
	}

}
