<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$("#writeform").submit(function(){
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
	<h1>글쓰기</h1>
	<a href="list">리스트</a><br><br>
	<form action="write" method="post" name="frm" id="writeform">
		<table style="width: 500" border="1">
			<tr>
				<th>제목</th>
				<td><input name="title" id="title" size="30" maxlength="100"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" id="content" rows="5" cols="40"></textarea></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input name="name" id="name" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="passwd" id="passwd" size="20" maxlength="20"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" />
					<input type="reset" value="취소" />
				</td>
			</tr>
		</table>
		
	</form>
</body>
</html>