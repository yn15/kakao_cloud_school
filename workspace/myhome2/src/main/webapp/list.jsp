<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//List<String> - 강제 형변환
	List<String> flowerList = (List<String>)request.getAttribute("flowerList");
	for(int i = 0; i<flowerList.size(); i++){
%>
		<h3><%=flowerList.get(i) %></h3>
<%  }%>
</body>
</html>