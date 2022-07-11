<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%

	String userid = request.getParameter("userid");
	JSONObject jo = new JSONObject();
	if(userid.equals("test")){
		jo.put("result", false);
	}else{
		jo.put("result", true);
	}

	out.println(jo);
%>