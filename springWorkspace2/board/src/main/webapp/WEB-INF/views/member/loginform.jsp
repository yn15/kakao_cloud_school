<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#loginform").submit(function(){
			if($("#id").val() == ""){
				alert("아이디를 꼭 입력해주세요");
				$("#id").focus();
				return false;
			}
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
	<h1>로그인</h1>
	<form action="${root}/member/login" method="post" name="loginform" id="loginform">
		<table style="width: 500px" border="1">
			<tr>
				<th>아이디</th>
				<td><input name="id" id="id" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" id="passwd" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" />
					<input type="reset" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>