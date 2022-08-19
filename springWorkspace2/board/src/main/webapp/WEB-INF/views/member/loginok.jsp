<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
	<h1>로그인 성공</h1>
	${id}님 어서오세요! <br>
	<a href="${root}/member/logout">로그아웃</a><br>
	<a href="${root}/member/updateform">회원 정보 수정</a><br>
	<a href="${root}/member/deleteform">회원 탈퇴</a><br>
</body>
</html>