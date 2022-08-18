<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<h1>리스트</h1>
	<a href="writeform">글쓰기</a><br><br>
	<table style="600px" border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td><a href="${root}/read/${b.no}">${b.title}</a></td>
			<td>${b.name}</td>
			<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			<td>${b.hit}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>