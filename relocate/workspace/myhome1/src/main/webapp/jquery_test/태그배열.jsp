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
	<h1>관촌수필</h1>
	<h1>마음의 감옥</h1>
	<h1>광장</h1>
	<h1>잔인한도시</h1>
	<h1>붉은달</h1>
	<h1>태백산맥</h1>
	<h1>임꺽정</h1>
	
	<button type="button" id="btnSelect">데이터 출력하기</button>
</body>
</html>
<script>
	$(function(){
		$("#btnSelect").click(function(){
			$("h1").each(function(i, item){
				console.log(item.innerHTML);
				console.log($(this).html())
			})
		})
		
		console.log($("h1").eq(1).html());
			
	})
		

</script>