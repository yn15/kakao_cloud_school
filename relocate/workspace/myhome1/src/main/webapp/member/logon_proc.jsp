<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String userid =request.getParameter("userid");
String pwd = request.getParameter("pwd");

if(userid.equals("test") && pwd.equals("1234")){	
%>
{"result":"success"}
<%}else{ %>
{"result":"fail"}
<%} %>
