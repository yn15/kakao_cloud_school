package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.service.MemberService;
import member.vo.Member;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/login")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
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
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPW");
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		MemberService service = new MemberService();
		
		member = service.login(member);
		
		if(member != null) {
			RequestDispatcher rd = request.getRequestDispatcher("/member/loginSuccess.jsp");
			request.setAttribute("member", member);
			rd.forward(request, response);
		}else {
			response.sendRedirect("/book/member/loginFail.html");
		}
	}

}
