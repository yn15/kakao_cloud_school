<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int x = Integer.parseInt(request.getParameter("x"));
	int y = Integer.parseInt(request.getParameter("y"));
	String op = request.getParameter("op");
	String res = "";
	String s = "";
	if(op.equals("btnSum")){
		s = "더하기 결과는";
		res = ""+(x+y);
	}
	else if(op.equals("btnSub")){
		s = "빼기 결과는";
		res = ""+(x-y);
	}
	else if(op.equals("btnMul")){
		s = "곱하기 결과는";
		res = ""+(x*y);
	}
	else if(op.equals("btnDiv")){
		s = "나누기 결과는";
		res = ""+((double)x/y);
	}
%>
{"result":"success", "value":"<%=res%>"}
