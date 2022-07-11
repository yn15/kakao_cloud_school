<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.json.JSONObject" %>
<%
//JSONObject - 사용법이 HashMap puh(키, 값)
JSONObject jo = new JSONObject();
jo.put("result", "success"); // {"result":"success"}
jo.put("value", "100");
jo.put("x", "10");
jo.put("y", "20");
out.println(jo);
%>