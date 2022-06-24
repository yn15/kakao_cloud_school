package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/User")
public class User extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setCharacterEncoding("utf-8");
    	
    	String userid = req.getParameter("userid");
    	String username = req.getParameter("username");
    	
    	PrintWriter out = resp.getWriter();
    	
    	out.print("<html>");
		out.print("<meta charset='utf-8'>");
		out.print("<body>");
		out.print("<h1>아이디 : " + userid + "</h1>");
		out.print("<h1>이름 : " + username + "</h1>");
		out.print("</body>");
		out.print("</html>");
	}
    
    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
