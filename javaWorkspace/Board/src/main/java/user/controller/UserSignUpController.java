package user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.UserService;
import user.vo.User;

/**
 * Servlet implementation class UserSiginUpController
 */
@WebServlet("/signup")
public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpController() {
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
		
		String userID = request.getParameter("userID");
		String userPW = request.getParameter("userPW");
		String userName = request.getParameter("userName"); 
		
		User user = new User();
		user.setUserID(userID);
		user.setUserPW(userPW);
		user.setUserName(userName);
		
		UserService service = new UserService();
		int result = service.signup(user);
		
		if(result == 1) {
			System.out.println("회원가입 완료");
			response.sendRedirect("/board/user/signupSuccess.jsp");
		}else if(result == -1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('이미 존재하는 ID입니다.'); location.href='"+"/board/user/signup.html"+"';</script>"); 
			//response.sendRedirect("/board/user/login.html");
			writer.close();
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('예기치 못한 오류 발생'); location.href='"+"/board/user/signup.html"+"';</script>"); 
			//response.sendRedirect("/board/user/login.html");
			writer.close();
		}
		
	}

}
