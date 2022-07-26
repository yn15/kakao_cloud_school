<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 입력
		// 2. 로직
		// 3. DB
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		out.println("안녕하세요");
	%>
	이것은 소리없는 아우성!<br><br>
	받은 데이터는 : <%= name%>
</body>
</html>