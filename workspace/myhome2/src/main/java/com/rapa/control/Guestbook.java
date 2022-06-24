package com.rapa.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rapa.common.CommonUtil;


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
		String cmd = CommonUtil.nullToValue(request.getParameter("cmd"),"list");
		if(cmd.equals("info")) {
			getInfo(request, response);
		}else if(cmd.equals("list")) {
			getList(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	void getInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//각 페이지에서 요청을 받으면 그 페이지가 바뀌면 받았던 요청은 절달이 안되는데
		//RequestDispatcher를 이용하면 요청이 다른 페이지로 이전된다.
		//원하는 jsp페이지를 매개변수로 전달하면 그 페이지로 이동시켜줌
		//부가적 정보를 저장해서 jsp로 전달 할 수 있다
		//request객체에 부가적인 정보를 저장하려면 setAttribute 함수를 사용한다
		//키와 값 형태로 정보 저장이 가능하다
		request.setAttribute("username", "불멸의 홍길동");
		request.setAttribute("age", 18);
		request.setAttribute("phone", "010-4444-5555");
		
		//parameter는 무조건 form태그를 통해서 가능하다, 프로그램으로 추가할 방법은 없다
		
		RequestDispatcher rd = request.getRequestDispatcher("/guest.jsp");
		rd.forward(request, response); //jsp페이지를 호출
	}
	
	void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> list = new ArrayList<String>(); //Generic 기법
		//List - 추상클래스
		//ArrayList - 구현클래스
		
		list.add("작약");
		list.add("쥐약");
		list.add("모란");
		list.add("장미");
		list.add("해바라기");
		list.add("튤립");
		list.add("천일홍");
		list.add("할미꽃");
		
		request.setAttribute("flowerList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/list.jsp");
		rd.forward(request, response);
	}
	
}
