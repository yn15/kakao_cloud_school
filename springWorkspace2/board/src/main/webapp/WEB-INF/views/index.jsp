<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index</h1>
	<a href="${root}writeform">글쓰기</a> <br>
	<a href="${root}list">리스트</a><br>
	<a href="${root}/member/join">회원 가입</a><br>
	<a href="${root}/member/loginform">로그인</a>
</body>
</html>