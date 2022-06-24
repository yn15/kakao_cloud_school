package com.rapa.control.guestbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;

@WebServlet("/guest.do")
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"),"list");
		if(cmd.equals("list"))
			doList(request, response);
		else if(cmd.equals("view")) {
			doView(request, response);
		}else if(cmd.equals("write")) {
			doWrite(request, response);
		}else if(cmd.equals("save")) {
			doSave(request, response);
		}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		request.setAttribute("dataList", dao.getList());
		
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_list.jsp");
		rd.forward(request, response);
	}
	
	void doView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		String id = request.getParameter("id");
		request.setAttribute("data", dao.getView(Integer.parseInt(id)-1));
		
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_view.jsp");
		rd.forward(request, response);
	}
	
	void doWrite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/guestbook/guest_write.jsp");
		rd.forward(request, response);
	}
	
	void doSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDto dto = new GuestbookDto();
		dto.setTitle(request.getParameter("title"));
		dto.setContents(request.getParameter("contents"));
		dto.setWriter(request.getParameter("writer"));
		dto.setWdate(request.getParameter("2022-06-24"));
		
		GuestbookDao dao = new GuestbookDao();
		dao.insert(dto);
		//새로고침시 데이터를 지우고 새로 가져온다.
		response.sendRedirect("/guest.do?cmd=list");
		
	}

}
