package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */

//http://127.0.0.1:9090/myhome2/hello
@WebServlet("/hello") //서버의 주소명은 바꿔도 url만 따라가면 됨
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super(); //부모생성자
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //GET방식으로 전달될 때 doGet 호출
    //request - 클라이언트(브라우저)의 요청을 받아오는 객체
    //response - 서버에서 클라이언트(브라우저)에게 응답을 보낼 때 사용하는 객체
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글 출력
		response.setCharacterEncoding("utf-8"); //한글 출력
		System.out.println("doget 콘솔창에");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<meta charset='utf-8'>"); //한글 출력 세개 다 해야한다
		out.print("<body>");
		out.print("<h1>Hello</h1>");
		out.print("<h1>안 녕 하하하하 세 요요요요요</h1>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//POST방식으로 전달될 때 doPost 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost 콘솔창에");
		doGet(request, response); //doGet을 호출해서 특별한 사항이 아니면 GET으로 오던 POST로 오던 처리하겠다.
	}

}
