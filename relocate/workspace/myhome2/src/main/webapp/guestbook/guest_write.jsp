<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.rapa.control.guestbook.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	<h1>방명록</h1>
	
	<form name="form">
		제목 : <input type="text" name="title" id="title"><br/>
		작성자 : <input type="text" name="writer" id="writer"><br/>
		내용 : <textarea name="contents" id="contents" rows="5" cols="80"></textarea>
		
		<button type="button" id="btnSend">등록</button>
	</form>
</body>
</html>
<script>
window.onload = function(){
	document.getElementById("btnSend").addEventListener("click", function(){
		var frm = document.form;
		frm.action="/myhome2/guest.do?cmd=save";
		frm.method="post";
		frm.submit();
	})
}
</script>