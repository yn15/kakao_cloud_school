package com.rapa.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Guestbook
 */
@WebServlet("/guest")
public class Guestbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Guestbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//각 페이지에서 요청을 받으면 그 페이지가 바뀌면 받았던 요청은 절달이 안되는데
		//RequestDispatcher를 이용하면 요청이 다른 페이지로 이전된다.
		//원하는 jsp페이지를 매개변수로 전달하면 그 페이지로 이동시켜줌
		RequestDispatcher rd = request.getRequestDispatcher("/guest.jsp");
		rd.forward(request, response); //jsp페이지를 호출
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
