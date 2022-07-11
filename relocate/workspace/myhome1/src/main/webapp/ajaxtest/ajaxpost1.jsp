<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <input type="text" name="username" id="username" /> <br/>
	전화 : <input type="text" name="phone" id="phone" /> <br/>
	이메일 : <input type="text" name="email" id="email" /> <br/>
	
	<button type="button" id="btnSend">보내기</button>
</body>
</html>
<script>
window.onload=function(){
	document.getElementById("btnSend").addEventListener("click", function(){
		
		let xhttp = new XMLHttpRequest();
		xhttp.onload = function(){
			console.log(this.responseText);
		}
		
		//form-data 는 파일보낼때
		//x-www-from-urlencoded 일반적 데이터 보낼때
		
		xhttp.open("POST", "receive2.jsp");
		xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		let temp = "username=" + document.getElementById("username").value;
		    temp += "&phone=" + document.getElementById("phone").value;
		    temp += "&email=" + document.getElementById("email").value;
		console.log(temp);
		xhttp.send(temp);
		
		
	})
}
</script>