<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%
	JSONArray jsonArray = new JSONArray();

	for(int i = 1; i<=10; i++){
		JSONObject jo = new JSONObject();
		jo.put("id", i+"");
		jo.put("title", "제목"+i);
		jo.put("writer", "작성자"+i);
		jo.put("hit",100+i);
		jsonArray.put(jo);
	}
	JSONObject result = new JSONObject();
	result.put("totalCnt", 10);
	result.put("data", jsonArray);
	out.println(result);
	
	//out.println(jsonArray);
	//out.println(jsonArray.get(0));
%>