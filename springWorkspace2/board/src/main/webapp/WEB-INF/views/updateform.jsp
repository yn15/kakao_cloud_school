<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script>
	$(function(){
		$("#updateform").submit(function(){
			if($("#title").val() == ""){
				alert("제목을 꼭 입력해주세요");
				$("#title").focus();
				return false;
			}
			if($("#content").val() == ""){
				alert("내용을 꼭 입력해주세요");
				$("#content").focus();
				return false;
			}
			if($("#name").val() == ""){
				alert("이름을 꼭 입력해주세요");
				$("#name").focus();
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
<h1>글 수정</h1>
<a href="${root}/list">리스트</a>
<form action="${root}/update" method="post" name="frm" id="updateform">
	<table style="width:500px" border="1">
		<tr>
			<th width="100">제목</th>
			<td>
				<input type="hidden" name="no" value="${b.no}">
				<input type="hidden" name="pg" value="${pg}">
				<input name="title" id="title" value="${b.title}" size="30" maxlength="100">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="content" id="content" rows="5" cols="40">${b.content}</textarea>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input name="name" id="name" value="${b.name}" size="20" maxlength="20">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="passwd" id="passwd" size="20" maxlength="20">
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	
</form>
</body>
</html>