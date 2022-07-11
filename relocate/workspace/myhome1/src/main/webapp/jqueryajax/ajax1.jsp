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
	<div id="result"></div>
	<button type="button" id="btnCall">파일불러오기</button>
	
</body>
</html>
<script>
$(()=>{
	$("#btnCall").click(()=>{
		$.ajax({ 
			url:"ajax_test.txt",
			method:"GET",
			dataType:"text" //수신시 데이터의 형식
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