<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</head>
<body>
	userid : <input type="text" id="userid"><br/>
	password : <input type="text" id="password"><br/>
	
	<div id="result"></div>
	<button type="button" id="btnCall">보내기</button>
	
</body>
</html>
<script>
$(()=>{
	$("#btnCall").click(()=>{
		$.ajax({ 
			url:"receive1.jsp",
			method:"GET",
			dataType:"text", //수신시 데이터의 형식
			data:{userid:$("#userid").val(), password:$("#password").val()}
		   })
		 .done((result)=>{   
		  	  $("#result").html(result);
		  })
		 
		 .fail((jqXhr, error) => {
			 console.log(error);
		 })
	})
})
</script>