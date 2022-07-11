package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

@WebServlet("/gugu")
public class Gugu extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dan = request.getParameter("dan");
		int sdan = Integer.parseInt(CommonUtil.nullToValue(dan, "2"));
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i<=9; i++) {
			sb.append(sdan + "X" + i + " = " + sdan*i + "<br>");
		}
		
		PrintWriter out = response.getWriter();
    	
    	out.print("<html>");
    	out.print("<h1>" + sdan + "dan </hr> </br> ");
		out.print("<h1>" + sb.toString() + "</h1>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
