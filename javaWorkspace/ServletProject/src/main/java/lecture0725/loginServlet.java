package lecture0725;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// 싱글톤
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 입력받음
		// 한가지 주의해야 할 점은.. 입력을 받을 때 사용되는 Stream이 encoding이 ISO-8859-1
		// 만약 한글 데이터를 전달받으려면 약간의 처리가 필요
		// 만약 GET방식인 경우 Tomcat의 입력 Stream의 encoding을 변경, server.xml 변경
		
		String email = request.getParameter("userEmail");
		String pw = request.getParameter("userPassword");
		// 2. 로직처리
		// 입력된 email과 password가 database table에 존재하는지 확인
		// JDBC code
		boolean loginStatus = false;
		
		String jdbcURL = "jdbc:mysql://localhost:3306/sqldb?characterEncoding=UTF-8&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(jdbcURL, "root", "1234");
			String sql = "SELECT * FROM tmpuser where email=? and password=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginStatus = true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null ) con.close();
			} catch (SQLException e) {
			}
			
		}

		// 3. 출력처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = new PrintWriter(response.getOutputStream());
		out.println("<html><head><body>");
		if(loginStatus) {
			out.println("환영합니다.");
		} else {
			out.println("로그인에 실패했습니다.");
		}
		out.println("</body></head></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 만약 POST방식인 경우 request.setCharacterEncoding("EUC-KR");
	}

}
