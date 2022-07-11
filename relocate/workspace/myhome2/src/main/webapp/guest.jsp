<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Guest</h1>
	
	<%
		//getAttribute 반환값이 Object 타입이다.
		//Object - 자바의 모든 클래스는 Object로부터 상속받는다
		String username = (String)request.getAttribute("username");
		int age = (Integer)request.getAttribute("age");
		String phone = (String)request.getAttribute("phone");
		
		out.println("이름 : " + username + "<br/>");
		out.println("나이 : " + age + "<br/>");
		out.println("전화 : " + phone + "<br/>");
	%>
</body>
</html>