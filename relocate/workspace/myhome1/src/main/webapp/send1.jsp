<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="myform">
		아이디 : <input type="text" name="userid"><br/>
		패스워드 : <input type="text" name="password"><br/>
		<button id="btnLogon">로그온</button>
	</form>
</body>
</html>
<script>
window.onload = function(){
	let btnLogon=document.getElementById("btnLogon");
	btnLogon.addEventListener("click",function(){
		let frm = document.myform;
		frm.action="receive1.jsp";
		frm.method="get";
		frm.submit();
	})
}
</script>