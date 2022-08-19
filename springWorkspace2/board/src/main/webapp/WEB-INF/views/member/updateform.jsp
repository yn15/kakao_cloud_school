<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#updateform").submit(function(){
			if($("#passwd").val() == ""){
				alert("비밀번호를 꼭 입력해주세요");
				$("#passwd").focus();
				return false;
			}
			if($("#name").val() == ""){
				alert("이름을 꼭 입력해주세요");
				$("#name").focus();
				return false;
			}
			if($("#email").val() == ""){
				alert("이메일을 꼭 입력해주세요");
				$("#email").focus();
				return false;
			}
			if($("#tel").val() == ""){
				alert("전화번호를 꼭 입력해주세요");
				$("#tel").focus();
				return false;
			}
			if($("#addr").val() == ""){
				alert("주소를 꼭 입력해주세요");
				$("#addr").focus();
				return false;
			}
			return true;
		})
	})
</script>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<form action="${root}/member/update" method="post" name="updateform" id="updateform">
		<table style="width: 500" border="1">
			<tr>
				<th>아이디</th>
				<td>${m.id} <input type="hidden" name="id" value="${m.id}"> </td>
				
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" id="passwd" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name" id="name" size="20" maxlength="20" value="${m.name}"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input name="email" id="email" size="30" maxlength="50" value="${m.email}"></td>
			</tr>
			<tr>
				<th>전화</th>
				<td><input name="tel" id="tel" size="11" maxlength="11" value="${m.tel}"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input name="addr" id="addr" size="30" maxlength="100" value="${m.addr}"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정" />
					<input type="reset" value="취소" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>