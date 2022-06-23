<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="org.json.*" %>
<%
	String userid = request.getParameter("userid");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String email = request.getParameter("email");
%>
<%=userid%><br/>
<%=username%><br/>
<%=password%><br/>
<%=phone%><br/>
<%=address%><br/>
<%=email%><br/>