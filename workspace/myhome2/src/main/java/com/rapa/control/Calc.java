package com.rapa.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int x = Integer.parseInt(request.getParameter("x")); int y =
		 * Integer.parseInt(request.getParameter("y")); int oper =
		 * Integer.parseInt(request.getParameter("oper")); int result = 0;
		 * 
		 * if(oper==1) result = (x+y); else if(oper==2) result = (x-y); else if(oper==3)
		 * result = (x*y); else if(oper==4) result = (x/y);
		 */
		
		String sx = CommonUtil.nullToValue(request.getParameter("x"));
		String sy = CommonUtil.nullToValue(request.getParameter("y"));
		String oper = CommonUtil.nullToValue(request.getParameter("oper"),"1");
		
		int nX = Integer.parseInt(sx);
		int nY = Integer.parseInt(sy);
		
		String result = "";
		if(oper.equals("1")) result = String.format("%d + %d = %d", nX, nY, nX+nY);
		else if(oper.equals("2")) result = String.format("%d - %d = %d", nX, nY, nX-nY);
		else if(oper.equals("3")) result = String.format("%d * %d = %d", nX, nY, nX*nY);
		else result = String.format("%d / %d = %d", nX, nY, nX/nY);
    	
    	PrintWriter out = response.getWriter();
    	
    	out.print("<html>");
		out.print("<h1>result : " + result + "</h1>");
		out.print("</html>");
		
//    	out.print("<html>");
//		out.print("<body>");
//		out.print("<h1>result : " + result + "</h1>");
//		out.print("</body>");
//		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
