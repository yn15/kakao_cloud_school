<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 읽기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn_update").on("click", function() {
			location.href = "${root}/updateform/${b.no}";
		})
		
		$("#del_span").hide();
		$("#btn_delete").on("click", function() {
			$("#del_span").show();
			$("#btn_update").hide();
			$("#btn_delete").hide();
		})
		
		$("#btn_cancel").on("click", function() {
			$("#del_span").hide();
			$("#btn_update").show();
			$("#btn_delete").show();
		})
		
		$("#btn_del").on("click", function() {
			if($("#passwd").val()==""){
				alert("비밀번호를 꼭 입력하세요");
				$("#passwd").focus();
				return;
			}
			readform.action="${root}/delete"
			readform.submit();
		});
	})
</script>
</head>
<body>
	<h1>글 읽기</h1>
	<a href="${root}/list">리스트</a><br><br>
	<form name="readform" id="readform" method="post">
		<table width="600px" border="1">
			<tr>
				<th>제목</th>
				<td>${b.title}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${b.name}</td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${b.hit}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><p><pre>${b.content}</pre></p></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btn_update" value="수정">
					<input type="button" id="btn_delete" value="삭제">
					<span id="del_span">
						<input type="hidden" name="no" value="${b.no}">
						비밀번호 : <input type="password" name="passwd" id="passwd" size="12" maxlength="20">
						<input type="button" id="btn_del" value="Del">
						<input type="button" id="btn_cancel" value="Cancel">
					</span>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>