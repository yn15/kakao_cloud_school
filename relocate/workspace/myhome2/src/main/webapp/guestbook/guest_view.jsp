<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.rapa.control.guestbook.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>방명록</h1>
	<% GuestbookDto data = (GuestbookDto)request.getAttribute("data");
	%>
	
	<%=data.getId()%><br/>
	<%=data.getTitle()%><br/>
	<%=data.getWriter()%><br/>
	<%=data.getWdate()%><br/>
	<%=data.getContents()%><br/>
	
</body>
</html>