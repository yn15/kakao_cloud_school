<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#deleteform").submit(function(){
			if($("#passwd").val() == ""){
				alert("비밀번호를 꼭 입력해주세요");
				$("#passwd").focus();
				return false;
			}
			return true;
		})
	})
</script>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="${root}/member/delete" method="post" name="deleteform" id="deleteform">
		<input type="hidden" name="id" id="id" value="${id}">
		비밀번호 : <input type="password" name="passwd" id="passwd" size="20" maxlength="20">
		<input type="submit" value="탈퇴">
		<input type="reset" value="취소">
	</form>
</body>
</html>