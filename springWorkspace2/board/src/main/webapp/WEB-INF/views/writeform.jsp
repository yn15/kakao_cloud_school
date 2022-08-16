<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글쓰기</h1>
	<a href="list">리스트</a><br><br>
	<form action="write" method="post" name="frm" id="writefrom">
		이름 : <input type="text">
		제목 : <input type="text">
		내용 : <textarea></textarea>
		비밀번호 : <input type="text">
	</form>
</body>
</html>